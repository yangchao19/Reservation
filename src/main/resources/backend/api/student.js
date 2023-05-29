function getStudentList (params) {
    return $axios({
        url: '/student/page',
        method: 'get',
        params
    })
}

function queryStudentById (id) {
    return $axios({
        url: `/student/${id}`,
        method: 'get',
    })
}

function editStudent (params) {
    return $axios({
        url: '/student',
        method: 'put',
        data: { ...params }
    })
}

function addStudent (params) {
    return $axios({
        url: '/student',
        method: 'post',
        data: { ...params }
    })
}