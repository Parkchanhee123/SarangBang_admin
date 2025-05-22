<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
    let cust_get = {
        init:function(){},
        update:function(id){
            let c = confirm('수정하시겠습니까?');
            if(c == true){
                location.href = '<c:url value="/cust/detail"/>?id=' + id;
            }
        },
        delete:function(id){
            let c = confirm('삭제하시겠습니까?');
            if(c == true){
                location.href = '<c:url value="/cust/delete"/>?id=' + id;
            }
        }
    };
    $(function(){
        cust_get.init();
    });
</script>

<div class="container-fluid">

    <!-- Page Heading -->
    <h1 class="h3 mb-2 text-gray-800">사용자 목록</h1>
    <p class="mb-4">MongoDB Atlas에서 가져온 사용자 데이터를 확인할 수 있습니다.</p>

    <!-- DataTales Example -->
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">User Collection</h6>
        </div>
        <div class="card-body">
            <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                    <thead>
                    <tr>
                        <th>UUID</th>
                        <th>Family Email</th>
                        <th>Registration Date</th>
                        <th>Update</th>
                        <th>Delete</th>
                    </tr>
                    </thead>
                    <tfoot>
                    <tr>
                        <th>UUID</th>
                        <th>Family Email</th>
                        <th>Registration Date</th>
                        <th>Update</th>
                        <th>Delete</th>
                    </tr>
                    </tfoot>
                    <tbody>
                    <c:forEach var="c" items="${custs}">
                        <tr>
                            <td><a href="<c:url value="/cust/detail"/>?id=${c.id}">${c.userUuid}</a></td>
                            <td>${c.userFamilyEmail}</td>
                            <td>${c.userDate}</td>
                            <td>
                                <button onclick="cust_get.update('${c.id}')" type="button" class="btn btn-primary">Update</button>
                            </td>
                            <td>
                                <button onclick="cust_get.delete('${c.id}')" type="button" class="btn btn-danger">Delete</button>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>

</div>
