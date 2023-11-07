function PrizeListApi(id) {
    return $axios({
        'url': `/lottery/queryLucky/${id}`,
        'method': 'get',
    })
}

function PrizeListApi(userId) {
    return $axios({
        'url': `/lottery/doDraw/${userId}`,
        'method': 'get',
    })
}