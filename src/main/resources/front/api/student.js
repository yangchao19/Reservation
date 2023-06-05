function queryStudentByIdAPI(id) {
    return $axios({
        'url':`/student/${id}`,
        'method': 'get',
    })
}

function updateAPI(data) {
    return $axios({
        'url':'/student',
        'method':'put',
        data
    })
}