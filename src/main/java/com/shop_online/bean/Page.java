package com.shop_online.bean;

public class Page {
    private int pageNow = 1;    // 当前页
    private int pageSize = 5;   // 每一页显示的记录数
    private int totalCount; // 总的记录数
    private int totalPageCount; // 总的页数

    private int startPos; // 开始位置，从0开始
    private boolean hasFirst; //是否有首页
    private boolean hasPre; //是否有前一页
    private boolean hasNext; //是否有下一页
    private boolean hasLast; //是否有最后一页

    /**
     * 构造函数传入 总记录数/当前页
     * @param totalCount
     * @param pageNow
     */
    public Page(int totalCount, int pageNow){
        this.totalCount = totalCount;
        this.pageNow = pageNow;
    }

    public int getTotalPageCount(){
        totalPageCount = getTotalCount()/getPageSize();
        return (totalCount % pageSize == 0) ? totalPageCount : totalPageCount + 1;
    }



    public int getPageNow() {
        return pageNow;
    }

    public void setPageNow(int pageNow) {
        this.pageNow = pageNow;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public void setTotalPageCount(int totalPageCount) {
        this.totalPageCount = totalPageCount;
    }

    public int getStartPos() {
        return startPos;
    }

    public void setStartPos(int startPos) {
        this.startPos = startPos;
    }

    /**
     * 是否是第一页
     * @return
     */
    public boolean isHasFirst() {
        return (pageNow == 1) ? false:true;
    }

    public void setHasFirst(boolean hasFirst) {
        this.hasFirst = hasFirst;
    }

    /**
     * 是否有首页
     * @return
     */
    public boolean isHasPre() {
        return isHasFirst()?true:false;
    }

    public void setHasPre(boolean hasPre) {
        this.hasPre = hasPre;
    }

    /**
     * 是否有下一页
     * @return
     */
    public boolean isHasNext() {
        return isHasLast()?true:false;
    }

    public void setHasNext(boolean hasNext) {
        this.hasNext = hasNext;
    }

    /**
     * 是否有尾页
     * @return
     */
    public boolean isHasLast() {
        return (pageNow == getTotalPageCount())?false:true;
    }

    public void setHasLast(boolean hasLast) {
        this.hasLast = hasLast;
    }
}
