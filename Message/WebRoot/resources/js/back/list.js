/*
 * ���ú�̨����ɾ������
 */
function deleteBatch(basePath){
	$("#mainForm").attr("action",basePath+"DeleteBatchServlet");
	$("#mainForm").submit();
}