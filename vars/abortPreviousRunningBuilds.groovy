import hudson.model.Result
import jenkins.model.CauseOfInterruption

def call() {
  // current build number
  def buildNumber = env.BUILD_NUMBER as int
  
  // iterate through current project runs
  build.getProject()._getRuns().iterator().each{ run ->
    def exec = run.getExecutor()
    def execBuildNumber = build.getId() as int
    // if the run is not a current build and it has executor (running) then stop it
    if( run!=build && exec!=null && execBuildNumber<buildNumber){
      //prepare the cause of interruption
      def cause = { "interrupted by build #${execBuildNumber}" as String } as CauseOfInterruption 
      exec.interrupt(Result.ABORTED, cause)
    }
  }
}
