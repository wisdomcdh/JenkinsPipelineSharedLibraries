def addComment(maps) {
  /* maps
  [
  access_key: '',
  data: ''
  ]
  */
  def issue_key = maps.get('issue_key')
  def body = maps.get('body')
  def q = maps.get('q')

  def result;
  withCredentials([string(credentialsId: maps.get('access_key'), variable: 'CURL_USER')]) {
    sh (
      script: """
        curl -s -X POST -u '${CURL_USER}' -H 'Content-Type: application/json' -d '${body}' https:///chalcak.atlassian.net/rest/api/2/issue/${issue_key}/comment
      """
    )
  }
}
