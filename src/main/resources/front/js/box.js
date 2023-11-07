$(function() {

    //签到按钮拖拽
    //首先，设置cookie值，使到不同的页面刷新拖拽的按钮位置不会变
    function setCookie(name, value, expires) {
        var oDate = new Date();
        oDate.setDate(oDate.getDate() + expires);
        document.cookie = name + '=' + value + ';expires=' + oDate;
    }

    function getCookie(name) {
        var arr = new Array();
        arr = document.cookie.split("; ");
        var i = 0;
        for (i = 0; i < arr.length; i++) {
            arr2 = arr[i].split("=");
            if (arr2[0] == name) {
                return arr2[1];
            }
        }
        return '';
    }

    function removeCookie(name) {
        setCookie(name, '随便什么值，反正都要被删除了', -1);
    }

    //判断a和b的原因是第一次打开，cookie中并没有相应的参数，所以当有参数时执行，
    // a和b只需要判断一个就好了
    var oDiv = document.getElementById('signCorner');

    var a = getCookie('xPosition');
    var b = getCookie('yPosition');
    if (a) {
        oDiv.style.left = a + 'px';
        oDiv.style.top = b + 'px';
    }

    var dragBox = document.getElementById('signCorner');

    dragBox.addEventListener("click", function() {
        window.location.href = this.href;
    })

    //拖拽中
    dragBox.addEventListener('touchmove', function (event) {
        event.preventDefault();//阻止其他事件
        // 如果这个元素的位置内只有一个手指的话
        if (event.targetTouches.length == 1) {
            var touch = event.targetTouches[0];
            // 元素与手指位置同步
            dragBox.style.left = touch.clientX + 'px';
            dragBox.style.top = touch.clientY + 'px';
            //由于页面中会有滚动，所以在这不能用pageX和pageY,要用clientX  clientY

        }
        51
    }, false);

    //拖拽结束，放手
    dragBox.addEventListener('touchend', function (event) {
        // 如果这个元素的位置内只有一个手指的话
        //拖拽结束，changedTouches列表是涉及当前事件的列表
        if (event.changedTouches.length == 1) {
            var touch = event.changedTouches[0];
            // 判断手指位置，放置元素，如果大于浏览器宽度的一半，则右贴边，小于等于则左贴边
            var halfViewWidth = window.innerWidth / 2;
            var halfWidth = $(dragBox).width() / 2;
            // 手指位置判断,竖直方向，超出屏幕的贴边，水平方向，超出屏幕贴边，
            //左边左贴边，右边右贴边
            if ((touch.clientX < 0) || (touch.clientX >= 0 && touch.clientX <= (halfViewWidth - halfWidth))) {
                dragBox.style.left = 20 + 'px'
            } else if (touch.clientX >= (halfViewWidth - halfWidth)) {
                dragBox.style.left = (window.innerWidth - 20 - $(dragBox).width()) + 'px'
            }
            if (touch.clientY < 0) {
                dragBox.style.top = 20 + 'px'
            } else if (touch.clientY >= window.innerHeight - $(dragBox).height()) {
                dragBox.style.top = (window.innerHeight - $(dragBox).height() - 20) + 'px'
            }
        }
        dragBox.touchmove = null;
        dragBox.touchend = null;
        setCookie('xPosition', oDiv.offsetLeft, 1);
        setCookie('yPosition', oDiv.offsetTop, 1);
    }, false);
})



