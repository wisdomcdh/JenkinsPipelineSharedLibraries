def addComment(maps) {
  /* maps
  [
  access_key: '',
  issue_key: '',
  body: ''
  ]
  */
  def issue_key = maps.get('issue_key')
  def body = maps.get('body')

  def result;
  withCredentials([string(credentialsId: maps.get('access_key'), variable: 'CURL_USER')]) {
    result = sh (
      script: """
        curl -s -X POST -u '${CURL_USER}' -H 'Content-Type: application/json' -d '${body}' https:///chalcak.atlassian.net/rest/api/2/issue/${issue_key}/comment
      """,
      returnStatus: true
    )
  }
  if(result != 0) {
    throw new Exception("addComment fail");
  }
}

def editIssue(maps) {
  /* maps
  [
  access_key: '',
  issue_key: '',
  body: ''
  ]
  */
  def issue_key = maps.get('issue_key')
  def body = maps.get('body')

  def result;
  withCredentials([string(credentialsId: maps.get('access_key'), variable: 'CURL_USER')]) {
    result = sh (
      script: """
        curl -s -X PUT -u '${CURL_USER}' -H 'Content-Type: application/json' -d '${body}' https:///chalcak.atlassian.net/rest/api/2/issue/${issue_key}
      """,
      returnStatus: true
    )
  }
  if(result != 0) {
    throw new Exception("editIssue fail");
  }
}
