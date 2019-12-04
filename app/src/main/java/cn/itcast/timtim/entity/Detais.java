package cn.itcast.timtim.entity;

import java.util.List;

public class Detais {
//景点详情
    /**
     * code : 200
     * msg : SUCCESS
     * data : {"scenicspot":{"selfid":256,"address":"重庆南岸区长生桥水云山庄","commentContent":"","commentUserRated":5,"ename":"Chong Qing Nan An Shui Yun Shan Zhuang","id":"25103","introduce":"南岸水云山庄农家乐位于长生桥镇新桥石河堰，可从南坪上南山后再经凉风垭到水云山庄，或者从外环高速到长生桥镇。水云山庄可供游客住宿、吃饭、钓鱼、球类运动及棋牌娱乐等等，有一定接待能力。","lat":0,"lng":0,"name":"重庆南岸水云山庄","picture":"https://m.tuniucdn.com/filebroker/cdn/online/ae/cb/aecb2238_w120_h120_c1_t0.jpg","region":"南岸区","type_name":"旅游度假区","main_pic":"https://m.tuniucdn.com/filebroker/cdn/online/ae/cb/aecb2238_w950_h600_c1_t0.jpg"},"imgsBeans":[],"maps":[{"attractions_id":"25103","id":10955,"sort":0,"title":"简介","content":"南岸水云山庄农家乐位于长生桥镇新桥石河堰，可从南坪上南山后再经凉风垭到水云山庄，或者从外环高速到长生桥镇。水云山庄可供游客住宿、吃饭、钓鱼、球类运动及棋牌娱乐等等，有一定接待能力。"},{"attractions_id":"25103","id":10956,"sort":1,"title":"电话","content":"023-62453846"},{"attractions_id":"25103","id":10957,"sort":2,"title":"地址","content":"重庆南岸区长生桥水云山庄"}]}
     */

    private int code;
    private String msg;
    private DataBean data;

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

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * scenicspot : {"selfid":256,"address":"重庆南岸区长生桥水云山庄","commentContent":"","commentUserRated":5,"ename":"Chong Qing Nan An Shui Yun Shan Zhuang","id":"25103","introduce":"南岸水云山庄农家乐位于长生桥镇新桥石河堰，可从南坪上南山后再经凉风垭到水云山庄，或者从外环高速到长生桥镇。水云山庄可供游客住宿、吃饭、钓鱼、球类运动及棋牌娱乐等等，有一定接待能力。","lat":0,"lng":0,"name":"重庆南岸水云山庄","picture":"https://m.tuniucdn.com/filebroker/cdn/online/ae/cb/aecb2238_w120_h120_c1_t0.jpg","region":"南岸区","type_name":"旅游度假区","main_pic":"https://m.tuniucdn.com/filebroker/cdn/online/ae/cb/aecb2238_w950_h600_c1_t0.jpg"}
         * imgsBeans : []
         * maps : [{"attractions_id":"25103","id":10955,"sort":0,"title":"简介","content":"南岸水云山庄农家乐位于长生桥镇新桥石河堰，可从南坪上南山后再经凉风垭到水云山庄，或者从外环高速到长生桥镇。水云山庄可供游客住宿、吃饭、钓鱼、球类运动及棋牌娱乐等等，有一定接待能力。"},{"attractions_id":"25103","id":10956,"sort":1,"title":"电话","content":"023-62453846"},{"attractions_id":"25103","id":10957,"sort":2,"title":"地址","content":"重庆南岸区长生桥水云山庄"}]
         */

        private ScenicspotBean scenicspot;
        private List<?> imgsBeans;

        private List<MapsBean> maps;

        public ScenicspotBean getScenicspot() {
            return scenicspot;
        }

        public void setScenicspot(ScenicspotBean scenicspot) {
            this.scenicspot = scenicspot;
        }

        public List<?> getImgsBeans() {
            return imgsBeans;
        }

        public void setImgsBeans(List<?> imgsBeans) {
            this.imgsBeans = imgsBeans;
        }

        public List<MapsBean> getMaps() {
            return maps;
        }

        public void setMaps(List<MapsBean> maps) {
            this.maps = maps;
        }

        public static class ScenicspotBean {
            /**
             * selfid : 256
             * address : 重庆南岸区长生桥水云山庄
             * commentContent :
             * commentUserRated : 5.0
             * ename : Chong Qing Nan An Shui Yun Shan Zhuang
             * id : 25103
             * introduce : 南岸水云山庄农家乐位于长生桥镇新桥石河堰，可从南坪上南山后再经凉风垭到水云山庄，或者从外环高速到长生桥镇。水云山庄可供游客住宿、吃饭、钓鱼、球类运动及棋牌娱乐等等，有一定接待能力。
             * lat : 0.0
             * lng : 0.0
             * name : 重庆南岸水云山庄
             * picture : https://m.tuniucdn.com/filebroker/cdn/online/ae/cb/aecb2238_w120_h120_c1_t0.jpg
             * region : 南岸区
             * type_name : 旅游度假区
             * main_pic : https://m.tuniucdn.com/filebroker/cdn/online/ae/cb/aecb2238_w950_h600_c1_t0.jpg
             */

            private int selfid;
            private String address;
            private String commentContent;
            private double commentUserRated;
            private String ename;
            private String id;
            private String introduce;
            private double lat;
            private double lng;
            private String name;
            private String picture;
            private String region;
            private String type_name;
            private String main_pic;

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

            public String getCommentContent() {
                return commentContent;
            }

            public void setCommentContent(String commentContent) {
                this.commentContent = commentContent;
            }

            public double getCommentUserRated() {
                return commentUserRated;
            }

            public void setCommentUserRated(double commentUserRated) {
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

            public String getIntroduce() {
                return introduce;
            }

            public void setIntroduce(String introduce) {
                this.introduce = introduce;
            }

            public double getLat() {
                return lat;
            }

            public void setLat(double lat) {
                this.lat = lat;
            }

            public double getLng() {
                return lng;
            }

            public void setLng(double lng) {
                this.lng = lng;
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

            public String getType_name() {
                return type_name;
            }

            public void setType_name(String type_name) {
                this.type_name = type_name;
            }

            public String getMain_pic() {
                return main_pic;
            }

            public void setMain_pic(String main_pic) {
                this.main_pic = main_pic;
            }
        }

        public static class MapsBean {
            /**
             * attractions_id : 25103
             * id : 10955.0
             * sort : 0.0
             * title : 简介
             * content : 南岸水云山庄农家乐位于长生桥镇新桥石河堰，可从南坪上南山后再经凉风垭到水云山庄，或者从外环高速到长生桥镇。水云山庄可供游客住宿、吃饭、钓鱼、球类运动及棋牌娱乐等等，有一定接待能力。
             */

            private String attractions_id;
            private double id;
            private double sort;
            private String title;
            private String content;

            public String getAttractions_id() {
                return attractions_id;
            }

            public void setAttractions_id(String attractions_id) {
                this.attractions_id = attractions_id;
            }

            public double getId() {
                return id;
            }

            public void setId(double id) {
                this.id = id;
            }

            public double getSort() {
                return sort;
            }

            public void setSort(double sort) {
                this.sort = sort;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }
        }
    }
}
