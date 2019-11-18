import hudson.model.Result
import jenkins.model.CauseOfInterruption

def call() {
    def jobName = env.JOB_NAME
    def currentBuildNumber = env.BUILD_NUMBER.toInteger()
    def currentJob = Jenkins.instance.getItemByFullName(jobName)

    for(def build : currentJob.builds) {
        if(build.isBuilding() && build.number.toInteger() < currentBuildNumber) {
            def exec = build.getExecutor();
            def cause = new CauseOfInterruption.UserInterruption("interrupted by build #${currentBuildNumber}")
            exec.interrupt(Result.ABORTED, cause)
        }
    }
}
