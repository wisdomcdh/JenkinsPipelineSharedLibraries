def branches(maps) {
  /* maps
  [
  access_key: '',
  workspace: '',
  repo_slug: '',
  q: ''
  ]
  */
  def workspace = maps.get('workspace')
  def repo_slug = maps.get('repo_slug')
  def q = maps.get('q')

  def result;
  withCredentials([string(credentialsId: maps.get('access_key'), variable: 'CURL_USER')]) {
    result = sh (
      script '''
        curl -s -G --data-urlencode '${q}' -u '${CURL_USER}' https://api.bitbucket.org/2.0/repositories/${workspace}/${repo_slug}/refs/branches | jq '.values [] | .name'
      '''
      returnStdout: true
    )
  }
  return result.split('\n');
}
