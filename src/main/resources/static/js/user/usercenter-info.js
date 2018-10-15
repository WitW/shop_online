var viewModel = avalon.define({
    $id:"viewModel",
    datalist:{},

})
$.ajax({
    type:"get",
    url:"/user/showUserInfo",
    data:{},
    success:function (data) {
        viewModel.data = data;
    }
})

}