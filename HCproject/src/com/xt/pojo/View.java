package com.xt.pojo;

public class View {

	    private int currentPage;// 记录当前的页数 

	    private int pageSize;// 每页显示的记录数 

	    private int recordCount;// 一共有多少条记录 

	 

	    public int getRecordCount() {
			return recordCount;
		}



		public View(int pageSize, int recordCount, int currentPage) { 

	        this.pageSize = pageSize; 

	        this.recordCount = recordCount; 

	        this.setCurrentPage(currentPage); 

	    } 

	 

	    // 计算总的页数 

	    public int getPageCount() { 

	        int size = recordCount / pageSize;// 总页数=总条数/每页要现实的记录 

	        int flag = recordCount % pageSize;// 取模运算，为了计算最后一页要显示的条数 

	        if (flag != 0) { 

	            size++; 

	        } 

	        // 根据记录数判断返回的总页数 

	        if (recordCount == 0) {// 如果有0条记录 

	            // 返回只有1页 

	            return 1; 

	        } 

	        // 返回计算出来的页数 

	        return size; 

	    } 

	 

	    // 设置sql语句中，limit的索引起始位置，从0开始 

	    public int getFromIndex() { 

	        return (currentPage - 1) * pageSize;// 重点算法:(当前页码-1)*每页记录数=索引的起始位置 

	    } 

	 

	    // 设置当前页 

	    public void setCurrentPage(int currentPage) { 

	        // 为什么要设置？ 

	        /*

	         * 因为：在jsp页面中，会放置首页和上一页，下一页和末页两个按钮

	         * 当在最后一页点击下一页时，此时获得页面数会大于实际的页面，所以页面就要保持在最后一页

	         * 当在第一页点击上一页，此时获得的页面数会小于或=0，此时就要一直保持在第一页

	         */ 

	        int vaildPage = currentPage <= 0 ? 1 : currentPage; 

	        vaildPage = vaildPage > this.getPageCount() ? this.getPageCount() 

	                : vaildPage; 

	        this.currentPage = vaildPage; 

	    } 

	 

	    // 得到当前页,用于显示在JSP中 

	    public int getCurrentPage() { 

	        return currentPage; 

	    } 

	 

	    // 得到每页显示的记录数 

	    public int getPageSize() { 

	        return pageSize; 

	    } 
}
