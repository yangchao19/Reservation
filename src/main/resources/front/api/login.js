function loginApi(data) {
    return $axios({
      'url': '/student/login',
      'method': 'post',
      data
    })
  }

function sendMsgApi(data) {
    return $axios({
        'url':'/student/sendMsg',
        'method':'post',
        data
    })
}

function loginOutApi() {
  return $axios({
    'url': '/student/loginout',
    'method': 'post',
  })
}

  