def addComment(maps) {
  /* maps
  [
  access_key: '',
  workspace: '',
  repo_slug: '',
  q: ''
  ]
  */
  withCredentials([s tring(credentialsId: maps.get('access_key'), variable: 'CURL_USER')]) {
    result = sh (
      script: """
        curl -s -G --data-urlencode '${q}' -u '${CURL_USER}' https://api.bitbucket.org/2.0/repositories/${workspace}/${repo_slug}/refs/branches | jq '.values | map({name})'
      """,
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
