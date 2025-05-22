<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
    let cust_detail = {
        init:function(){
            $('#detail_form > #btn_update').click(()=>{
                this.send();
            });
            $('#detail_form > #btn_delete').click(()=>{
                let c = confirm('삭제하시겠습니까?');
                if(c === true){
                    let id = $('#id').val();
                    location.href = '<c:url value="/cust/delete"/>?id=' + id;
                }
            });
        },
        send:function(){
            $('#detail_form').attr({
                'method':'post',
                'action':'<c:url value="/cust/update"/>'
            });
            $('#detail_form').submit();
        }
    };
    $(function(){
        cust_detail.init();
    });
</script>

<div class="container-fluid">

    <h1 class="h3 mb-2 text-gray-800">사용자 상세정보</h1>

    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">User Detail</h6>
        </div>
        <div class="card-body">
            <div class="table-responsive">
                <form id="detail_form">
                    <div class="form-group">
                        <label for="id">MongoDB ID (_id):</label>
                        <input type="text" readonly="readonly" value="${cust.id}" class="form-control" id="id" name="id">
                    </div>

                    <div class="form-group">
                        <label for="user_uuid">User UUID:</label>
                        <input type="text" value="${cust.user_uuid}" class="form-control" id="user_uuid" name="user_uuid">
                    </div>

                    <div class="form-group">
                        <label for="user_family_email">Family Email:</label>
                        <input type="email" value="${cust.user_family_email}" class="form-control" id="user_family_email" name="user_family_email">
                    </div>

                    <div class="form-group">
                        <label for="user_date">가입일자:</label>
                        <input type="text" value="${cust.user_date}" class="form-control" id="user_date" name="user_date">
                    </div>

                    <button id="btn_update" type="button" class="btn btn-primary">Update</button>
                    <button id="btn_delete" type="button" class="btn btn-danger">Delete</button>
                </form>
            </div>
        </div>
    </div>

</div>
