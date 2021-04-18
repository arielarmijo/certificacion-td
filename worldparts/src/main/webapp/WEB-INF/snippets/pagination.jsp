<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<nav>
	<ul class="pagination justify-content-center">
		<c:url var="pageLink" value="/">
			<c:param name="warehouseId" value="${warehouseId}"/>
			<c:param name="productCategoryId" value="${productCategoryId}"/>
			<c:param name="sortBy" value="${sortBy}"/>
		</c:url>
		<li class="page-item ${currentPage == 0 ? 'disabled':''}">
			<a class="page-link" href="${pageLink}&page=${currentPage-1}">Anterior</a>
		</li>
		<c:forEach var="i" begin="${startPage}" end="${endPage}">
		    <li class="page-item ${currentPage == i ? 'active':''}">
		    	<a class="page-link" href="${pageLink}&page=${i}">${i + 1}</a>
		    </li>
		</c:forEach>
		<li class="page-item ${currentPage == totalPages - 1 ? 'disabled':''}">
			<a class="page-link" href="${pageLink}&page=${currentPage+1}">Siguiente</a>
		</li>
  	</ul>
</nav>