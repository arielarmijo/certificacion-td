<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<nav>
	<ul class="pagination justify-content-center">
		<li class="page-item ${currentPage == 0 ? 'disabled':''}">
			<c:url var="previousPageLink" value="/">
				<c:param name="warehouseId" value="${warehouseId}"/>
				<c:param name="productCategoryId" value="${productCategoryId}"/>
				<c:param name="page" value="${currentPage - 1}"/>
			</c:url>
			<a class="page-link" href="${previousPageLink}">Anterior</a>
		</li>
		<c:forEach var="i" begin="${startPage}" end="${endPage}">
			<c:url var="pageLink" value="/">
				<c:param name="warehouseId" value="${warehouseId}"/>
				<c:param name="productCategoryId" value="${productCategoryId}"/>
				<c:param name="page" value="${i}"/>
			</c:url>
		    <li class="page-item ${currentPage == i ? 'active':''}">
		    	<a class="page-link" href="${pageLink}">${i + 1}</a>
		    </li>
		</c:forEach>
		<li class="page-item ${currentPage == totalPages - 1 ? 'disabled':''}">
			<c:url var="nextPageLink" value="/">
				<c:param name="warehouseId" value="${warehouseId}"/>
				<c:param name="productCategoryId" value="${productCategoryId}"/>
				<c:param name="page" value="${currentPage + 1}"/>
			</c:url>
			<a class="page-link" href="${nextPageLink}">Siguiente</a>
		</li>
  	</ul>
</nav>