function getCurriculumList (params) {
    return $axios({
        url: '/curriculum/page',
        method: 'get',
        params
    })
}

function queryCurriculumById (id) {
    return $axios({
        url: `/curriculum/${id}`,
        method: 'get',
    })
}

function editCurriculum (params) {
    return $axios({
        url: '/curriculum',
        method: 'put',
        data: { ...params }
    })
}

function addCurriculum (params) {
    return $axios({
        url: '/curriculum',
        method: 'post',
        data: { ...params }
    })
}