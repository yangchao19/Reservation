function loginApi(data) {
  return $axios({
    'url': '/teacher/login',
    'method': 'post',
    data
  })
}

function logoutApi(){
  return $axios({
    'url': '/teacher/logout',
    'method': 'post',
  })
}
