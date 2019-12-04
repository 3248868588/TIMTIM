package cn.itcast.timtim.entity;

import java.util.List;

public class attractions {
//景点列表
    /**
     * code : 200
     * msg : success
     * data : [{"selfid":256,"address":"重庆南岸区长生桥水云山庄","commentUserRated":5,"ename":"Chong Qing Nan An Shui Yun Shan Zhuang","id":"25103","name":"重庆南岸水云山庄","picture":"https://m.tuniucdn.com/filebroker/cdn/online/ae/cb/aecb2238_w120_h120_c1_t0.jpg","region":"南岸区","typeName":"旅游度假区","distance":"11609973"}]
     */

    private int code;
    private String msg;
    private List<DataBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * selfid : 256
         * address : 重庆南岸区长生桥水云山庄
         * commentUserRated : 5
         * ename : Chong Qing Nan An Shui Yun Shan Zhuang
         * id : 25103
         * name : 重庆南岸水云山庄
         * picture : https://m.tuniucdn.com/filebroker/cdn/online/ae/cb/aecb2238_w120_h120_c1_t0.jpg
         * region : 南岸区
         * typeName : 旅游度假区
         * distance : 11609973
         */

        private int selfid;
        private String address;
        private float commentUserRated;
        private String ename;
        private String id;
        private String name;
        private String picture;
        private String region;
        private String typeName;
        private String distance;

        public DataBean(int selfid, String address, float commentUserRated,
                        String attrEname, String id, String attrname,
                        String picture, String region, String typename, String distance) {
        }

        public int getSelfid() {
            return selfid;
        }

        public void setSelfid(int selfid) {
            this.selfid = selfid;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public float getCommentUserRated() {
            return commentUserRated;
        }

        public void setCommentUserRated(float commentUserRated) {
            this.commentUserRated = commentUserRated;
        }

        public String getEname() {
            return ename;
        }

        public void setEname(String ename) {
            this.ename = ename;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPicture() {
            return picture;
        }

        public void setPicture(String picture) {
            this.picture = picture;
        }

        public String getRegion() {
            return region;
        }

        public void setRegion(String region) {
            this.region = region;
        }

        public String getTypeName() {
            return typeName;
        }

        public void setTypeName(String typeName) {
            this.typeName = typeName;
        }

        public String getDistance() {
            return distance;
        }

        public void setDistance(String distance) {
            this.distance = distance;
        }
    }
}
