/*
 * ���ú�̨����ɾ������
 */
function deleteBatch(basePath){
	$("#mainForm").attr("action",basePath+"DeleteBatchServlet");
	$("#mainForm").submit();
}

/**
 * �޸ĵ�ǰҳ�룬���ú�̨���²�ѯ
 */
function changeCurrentPage(currentPage) {
	$("#currentPage").val(currentPage);
	$("#mainForm").submit();
}