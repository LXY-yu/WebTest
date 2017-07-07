package com.xt.pojo;

public class View {

	    private int currentPage;// ��¼��ǰ��ҳ�� 

	    private int pageSize;// ÿҳ��ʾ�ļ�¼�� 

	    private int recordCount;// һ���ж�������¼ 

	 

	    public int getRecordCount() {
			return recordCount;
		}



		public View(int pageSize, int recordCount, int currentPage) { 

	        this.pageSize = pageSize; 

	        this.recordCount = recordCount; 

	        this.setCurrentPage(currentPage); 

	    } 

	 

	    // �����ܵ�ҳ�� 

	    public int getPageCount() { 

	        int size = recordCount / pageSize;// ��ҳ��=������/ÿҳҪ��ʵ�ļ�¼ 

	        int flag = recordCount % pageSize;// ȡģ���㣬Ϊ�˼������һҳҪ��ʾ������ 

	        if (flag != 0) { 

	            size++; 

	        } 

	        // ���ݼ�¼���жϷ��ص���ҳ�� 

	        if (recordCount == 0) {// �����0����¼ 

	            // ����ֻ��1ҳ 

	            return 1; 

	        } 

	        // ���ؼ��������ҳ�� 

	        return size; 

	    } 

	 

	    // ����sql����У�limit��������ʼλ�ã���0��ʼ 

	    public int getFromIndex() { 

	        return (currentPage - 1) * pageSize;// �ص��㷨:(��ǰҳ��-1)*ÿҳ��¼��=��������ʼλ�� 

	    } 

	 

	    // ���õ�ǰҳ 

	    public void setCurrentPage(int currentPage) { 

	        // ΪʲôҪ���ã� 

	        /*

	         * ��Ϊ����jspҳ���У��������ҳ����һҳ����һҳ��ĩҳ������ť

	         * �������һҳ�����һҳʱ����ʱ���ҳ���������ʵ�ʵ�ҳ�棬����ҳ���Ҫ���������һҳ

	         * ���ڵ�һҳ�����һҳ����ʱ��õ�ҳ������С�ڻ�=0����ʱ��Ҫһֱ�����ڵ�һҳ

	         */ 

	        int vaildPage = currentPage <= 0 ? 1 : currentPage; 

	        vaildPage = vaildPage > this.getPageCount() ? this.getPageCount() 

	                : vaildPage; 

	        this.currentPage = vaildPage; 

	    } 

	 

	    // �õ���ǰҳ,������ʾ��JSP�� 

	    public int getCurrentPage() { 

	        return currentPage; 

	    } 

	 

	    // �õ�ÿҳ��ʾ�ļ�¼�� 

	    public int getPageSize() { 

	        return pageSize; 

	    } 
}
