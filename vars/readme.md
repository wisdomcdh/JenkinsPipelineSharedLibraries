## abortPreviousRunningBuilds
현재 빌드 번호 이전의 빌드중인 내역을 취소 시킵니다.

### `abortPreviousRunningBuilds()`

```groovy
abortPreviousRunningBuilds()
```

## line
line API를 사용할 수 있습니다. https://notify-bot.line.me/doc/en/

### `notify`
POST `https://notify-api.line.me/api/notify` API

```groovy
line.notify access_token: 'your token', message: 'message', imageThumbnail: 'optional', imageFullsize: 'optional', stickerPackageId: 'optional', stickerId: 'optional', notificationDisabled: 'optional'

// ex
line.notify access_token: 'my credentialsId', message: 'hello world'
```

##### parameters

| name | Description |
| --- | --- |
| access_token | [require] jenkins credentials id |
| message | [require] send message |
| imageThumbnail | [optional] HTTP/HTTPS URL Maximum size of 240×240px JPEG |
| imageFullsize | [optional] HTTP/HTTPS URL 	Maximum size of 2048×2048px JPEG |
| imageFile | [optional] FileName Upload a image file to the LINE server. |
| stickerPackageId | [optional] Package ID. |
| stickerId | [optional] 	Sticker ID. |
| notificationDisabled | [optional] management push notification |
