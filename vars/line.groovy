def notify(maps) {
  /* maps 
  [
  access_token: !!! credentialsId<access_token> !!!,
  message: message,
  imageThumbnail: (Optional) HTTP/HTTPS URL Maximum size of 240×240px JPEG,
  imageFullsize: (Optional) HTTP/HTTPS URL Maximum size of 2048×2048px JPEG,
  imageFile: not support,
  stickerPackageId: (Optional) Number,
  stickerId: (Optional) Number,
  notificationDisabled: (Optional) Boolean,
  ]
  */
  def postdata = ''
  postdata += 'message=' + maps.get('message')
  if(maps.containsKey('imageThumbnail')) {
    postdata += '&imageThumbnail=' + java.net.URLEncoder.encode(maps.get('imageThumbnail'), 'UTF-8')
  }
  if(maps.containsKey('imageFullsize')) {
    postdata += '&imageFullsize=' + java.net.URLEncoder.encode(maps.get('imageFullsize'), 'UTF-8')
  }
  if(maps.containsKey('stickerPackageId')) {
    postdata += '&stickerPackageId=' + java.net.URLEncoder.encode(maps.get('stickerPackageId'), 'UTF-8')
  }
  if(maps.containsKey('notificationDisabled')) {
    postdata += '&notificationDisabled=' + java.net.URLEncoder.encode(maps.get('notificationDisabled'), 'UTF-8')
  }
     
  withCredentials([string(credentialsId: maps.get('access_token'), variable: 'LINE_NOTI_TOKEN')]) {
      // 문자열의 표현식을 바꾸려면 작은 따옴표 대신 큰 따옴표를 사용해야 합니다.
      sh """
      curl -X POST -H "Authorization: Bearer ${LINE_NOTI_TOKEN}" -F "${postdata}" https://notify-api.line.me/api/notify
      """
  }
}
