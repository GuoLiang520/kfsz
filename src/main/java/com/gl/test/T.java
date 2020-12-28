package com.gl.test;

import com.alibaba.fastjson.JSONObject;
import lombok.ToString;

import java.util.List;

public class T {

    public static void main(String[] args) {
        A a = JSONObject.parseObject("{\n" +
                "\t\"ts\": \"2020-12-24 22:37:39\",\n" +
                "\t\"gyshyj\": \"\",\n" +
                "\t\"nbyj\": \"\",\n" +
                "\t\"data_tenant_id\": \"\",\n" +
                "\t\"data_dept_code\": \"1001D001B001\",\n" +
                "\t\"c_uid\": \"b902a1ccc07147cbb871f18680745f09\",\n" +
                "\t\"sheng_\": \"11\",\n" +
                "\t\"zyshyj\": \"\",\n" +
                "\t\"dsrlist\": \"[{\\\"id\\\":\\\"4080e505691a8eee016922c89fbe009d\\\",\\\"data\\\":[{\\\"id\\\":\\\"55d98b8bd57344d0bc1e44adce96cea9\\\",\\\"dsrmc\\\":\\\"123\\\",\\\"ssdw\\\":\\\"5\\\",\\\"dsrlx\\\":\\\"4\\\",\\\"columnId\\\":1608820656007,\\\"lineNum\\\":0},{\\\"id\\\":\\\"7d56f5ba931e4800b31105782c7de643\\\",\\\"dsrmc\\\":\\\"321\\\",\\\"ssdw\\\":\\\"6\\\",\\\"dsrlx\\\":\\\"4\\\",\\\"columnId\\\":1608820656008,\\\"lineNum\\\":1}]}]\",\n" +
                "\t\"ajnh\": \"2020\",\n" +
                "\t\"id\": \"021d2564-9d0d-429e-bc7c-686bb5bd7126\",\n" +
                "\t\"title\": \"123\",\n" +
                "\t\"cbbm\": \"321\",\n" +
                "\t\"slfyName_\": \"北京市高级人民法院\",\n" +
                "\t\"ajlx\": \"2\",\n" +
                "\t\"ajbh\": \"2\",\n" +
                "\t\"data_org_id\": \"4080e505691a8eee01691abf5e990004\",\n" +
                "\t\"ajbljd\": \"1\",\n" +
                "\t\"st\": \"1\",\n" +
                "\t\"sw\": \"1\",\n" +
                "\t\"dr\": \"N\",\n" +
                "\t\"slfy_\": \"1\",\n" +
                "\t\"cznd\": \"123123213\",\n" +
                "\t\"ssfy_\": \"\",\n" +
                "\t\"data_user_id\": \"b902a1ccc07147cbb871f18680745f09\",\n" +
                "\t\"zayName_\": \"婚约财产纠纷\",\n" +
                "\t\"cbr\": \"123\",\n" +
                "\t\"dwcj\": \"1\",\n" +
                "\t\"zdmgdjjy\": \"1\",\n" +
                "\t\"zgfshyj\": \"\",\n" +
                "\t\"zdmgsy\": \"9\",\n" +
                "\t\"larq\": \"2020-12-10\",\n" +
                "\t\"djrq\": \"2020-12-24\",\n" +
                "\t\"ajsjgj\": \"2\",\n" +
                "\t\"sg\": \"1\",\n" +
                "\t\"spzh\": \"京民初\",\n" +
                "\t\"sa\": \"1\",\n" +
                "\t\"sfqdajxt\": \"swhyj\",\n" +
                "\t\"djrName_\": \"审管办\",\n" +
                "\t\"zay_\": \"9014\",\n" +
                "\t\"shengName_\": \"北京市\",\n" +
                "\t\"slcx\": \"1\",\n" +
                "\t\"lxfs\": \"123213213\"\n" +
                "}", A.class);
        System.out.println(a.toString());
    }
}

@ToString
class A{

    /**
     * ts : 2020-12-24 22:37:39
     * gyshyj :
     * nbyj :
     * data_tenant_id :
     * data_dept_code : 1001D001B001
     * c_uid : b902a1ccc07147cbb871f18680745f09
     * sheng_ : 11
     * zyshyj :
     * dsrlist : [{"id":"4080e505691a8eee016922c89fbe009d","data":[{"id":"55d98b8bd57344d0bc1e44adce96cea9","dsrmc":"123","ssdw":"5","dsrlx":"4","columnId":1608820656007,"lineNum":0},{"id":"7d56f5ba931e4800b31105782c7de643","dsrmc":"321","ssdw":"6","dsrlx":"4","columnId":1608820656008,"lineNum":1}]}]
     * ajnh : 2020
     * id : 021d2564-9d0d-429e-bc7c-686bb5bd7126
     * title : 123
     * cbbm : 321
     * slfyName_ : 北京市高级人民法院
     * ajlx : 2
     * ajbh : 2
     * data_org_id : 4080e505691a8eee01691abf5e990004
     * ajbljd : 1
     * st : 1
     * sw : 1
     * dr : N
     * slfy_ : 1
     * cznd : 123123213
     * ssfy_ :
     * data_user_id : b902a1ccc07147cbb871f18680745f09
     * zayName_ : 婚约财产纠纷
     * cbr : 123
     * dwcj : 1
     * zdmgdjjy : 1
     * zgfshyj :
     * zdmgsy : 9
     * larq : 2020-12-10
     * djrq : 2020-12-24
     * ajsjgj : 2
     * sg : 1
     * spzh : 京民初
     * sa : 1
     * sfqdajxt : swhyj
     * djrName_ : 审管办
     * zay_ : 9014
     * shengName_ : 北京市
     * slcx : 1
     * lxfs : 123213213
     */

    private String ts;
    private String gyshyj;
    private String nbyj;
    private String data_tenant_id;
    private String data_dept_code;
    private String c_uid;
    private String sheng_;
    private String zyshyj;
    private String dsrlist;
    private String ajnh;
    private String id;
    private String title;
    private String cbbm;
    private String slfyName_;
    private String ajlx;
    private String ajbh;
    private String data_org_id;
    private String ajbljd;
    private String st;
    private String sw;
    private String dr;
    private String slfy_;
    private String cznd;
    private String ssfy_;
    private String data_user_id;
    private String zayName_;
    private String cbr;
    private String dwcj;
    private String zdmgdjjy;
    private String zgfshyj;
    private String zdmgsy;
    private String larq;
    private String djrq;
    private String ajsjgj;
    private String sg;
    private String spzh;
    private String sa;
    private String sfqdajxt;
    private String djrName_;
    private String zay_;
    private String shengName_;
    private String slcx;
    private String lxfs;

    public String getTs() {
        return ts;
    }

    public void setTs(String ts) {
        this.ts = ts;
    }

    public String getGyshyj() {
        return gyshyj;
    }

    public void setGyshyj(String gyshyj) {
        this.gyshyj = gyshyj;
    }

    public String getNbyj() {
        return nbyj;
    }

    public void setNbyj(String nbyj) {
        this.nbyj = nbyj;
    }

    public String getData_tenant_id() {
        return data_tenant_id;
    }

    public void setData_tenant_id(String data_tenant_id) {
        this.data_tenant_id = data_tenant_id;
    }

    public String getData_dept_code() {
        return data_dept_code;
    }

    public void setData_dept_code(String data_dept_code) {
        this.data_dept_code = data_dept_code;
    }

    public String getC_uid() {
        return c_uid;
    }

    public void setC_uid(String c_uid) {
        this.c_uid = c_uid;
    }

    public String getSheng_() {
        return sheng_;
    }

    public void setSheng_(String sheng_) {
        this.sheng_ = sheng_;
    }

    public String getZyshyj() {
        return zyshyj;
    }

    public void setZyshyj(String zyshyj) {
        this.zyshyj = zyshyj;
    }

    public String getDsrlist() {
        return dsrlist;
    }

    public void setDsrlist(String dsrlist) {
        this.dsrlist = dsrlist;
    }

    public String getAjnh() {
        return ajnh;
    }

    public void setAjnh(String ajnh) {
        this.ajnh = ajnh;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCbbm() {
        return cbbm;
    }

    public void setCbbm(String cbbm) {
        this.cbbm = cbbm;
    }

    public String getSlfyName_() {
        return slfyName_;
    }

    public void setSlfyName_(String slfyName_) {
        this.slfyName_ = slfyName_;
    }

    public String getAjlx() {
        return ajlx;
    }

    public void setAjlx(String ajlx) {
        this.ajlx = ajlx;
    }

    public String getAjbh() {
        return ajbh;
    }

    public void setAjbh(String ajbh) {
        this.ajbh = ajbh;
    }

    public String getData_org_id() {
        return data_org_id;
    }

    public void setData_org_id(String data_org_id) {
        this.data_org_id = data_org_id;
    }

    public String getAjbljd() {
        return ajbljd;
    }

    public void setAjbljd(String ajbljd) {
        this.ajbljd = ajbljd;
    }

    public String getSt() {
        return st;
    }

    public void setSt(String st) {
        this.st = st;
    }

    public String getSw() {
        return sw;
    }

    public void setSw(String sw) {
        this.sw = sw;
    }

    public String getDr() {
        return dr;
    }

    public void setDr(String dr) {
        this.dr = dr;
    }

    public String getSlfy_() {
        return slfy_;
    }

    public void setSlfy_(String slfy_) {
        this.slfy_ = slfy_;
    }

    public String getCznd() {
        return cznd;
    }

    public void setCznd(String cznd) {
        this.cznd = cznd;
    }

    public String getSsfy_() {
        return ssfy_;
    }

    public void setSsfy_(String ssfy_) {
        this.ssfy_ = ssfy_;
    }

    public String getData_user_id() {
        return data_user_id;
    }

    public void setData_user_id(String data_user_id) {
        this.data_user_id = data_user_id;
    }

    public String getZayName_() {
        return zayName_;
    }

    public void setZayName_(String zayName_) {
        this.zayName_ = zayName_;
    }

    public String getCbr() {
        return cbr;
    }

    public void setCbr(String cbr) {
        this.cbr = cbr;
    }

    public String getDwcj() {
        return dwcj;
    }

    public void setDwcj(String dwcj) {
        this.dwcj = dwcj;
    }

    public String getZdmgdjjy() {
        return zdmgdjjy;
    }

    public void setZdmgdjjy(String zdmgdjjy) {
        this.zdmgdjjy = zdmgdjjy;
    }

    public String getZgfshyj() {
        return zgfshyj;
    }

    public void setZgfshyj(String zgfshyj) {
        this.zgfshyj = zgfshyj;
    }

    public String getZdmgsy() {
        return zdmgsy;
    }

    public void setZdmgsy(String zdmgsy) {
        this.zdmgsy = zdmgsy;
    }

    public String getLarq() {
        return larq;
    }

    public void setLarq(String larq) {
        this.larq = larq;
    }

    public String getDjrq() {
        return djrq;
    }

    public void setDjrq(String djrq) {
        this.djrq = djrq;
    }

    public String getAjsjgj() {
        return ajsjgj;
    }

    public void setAjsjgj(String ajsjgj) {
        this.ajsjgj = ajsjgj;
    }

    public String getSg() {
        return sg;
    }

    public void setSg(String sg) {
        this.sg = sg;
    }

    public String getSpzh() {
        return spzh;
    }

    public void setSpzh(String spzh) {
        this.spzh = spzh;
    }

    public String getSa() {
        return sa;
    }

    public void setSa(String sa) {
        this.sa = sa;
    }

    public String getSfqdajxt() {
        return sfqdajxt;
    }

    public void setSfqdajxt(String sfqdajxt) {
        this.sfqdajxt = sfqdajxt;
    }

    public String getDjrName_() {
        return djrName_;
    }

    public void setDjrName_(String djrName_) {
        this.djrName_ = djrName_;
    }

    public String getZay_() {
        return zay_;
    }

    public void setZay_(String zay_) {
        this.zay_ = zay_;
    }

    public String getShengName_() {
        return shengName_;
    }

    public void setShengName_(String shengName_) {
        this.shengName_ = shengName_;
    }

    public String getSlcx() {
        return slcx;
    }

    public void setSlcx(String slcx) {
        this.slcx = slcx;
    }

    public String getLxfs() {
        return lxfs;
    }

    public void setLxfs(String lxfs) {
        this.lxfs = lxfs;
    }
}

class B{

    /**
     * id : 4080e505691a8eee016922c89fbe009d
     * data : [{"id":"55d98b8bd57344d0bc1e44adce96cea9","dsrmc":"123","ssdw":"5","dsrlx":"4","columnId":1608820656007,"lineNum":0},{"id":"7d56f5ba931e4800b31105782c7de643","dsrmc":"321","ssdw":"6","dsrlx":"4","columnId":1608820656008,"lineNum":1}]
     */

    private String id;
    /**
     * id : 55d98b8bd57344d0bc1e44adce96cea9
     * dsrmc : 123
     * ssdw : 5
     * dsrlx : 4
     * columnId : 1608820656007
     * lineNum : 0
     */

    private List<DataBean> data;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        private String id;
        private String dsrmc;
        private String ssdw;
        private String dsrlx;
        private long columnId;
        private int lineNum;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getDsrmc() {
            return dsrmc;
        }

        public void setDsrmc(String dsrmc) {
            this.dsrmc = dsrmc;
        }

        public String getSsdw() {
            return ssdw;
        }

        public void setSsdw(String ssdw) {
            this.ssdw = ssdw;
        }

        public String getDsrlx() {
            return dsrlx;
        }

        public void setDsrlx(String dsrlx) {
            this.dsrlx = dsrlx;
        }

        public long getColumnId() {
            return columnId;
        }

        public void setColumnId(long columnId) {
            this.columnId = columnId;
        }

        public int getLineNum() {
            return lineNum;
        }

        public void setLineNum(int lineNum) {
            this.lineNum = lineNum;
        }
    }
}