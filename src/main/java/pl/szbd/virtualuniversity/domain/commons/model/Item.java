package pl.szbd.virtualuniversity.domain.commons.model;

public class Item {

        private Long ret;
        private String dsp;

        public Long getRet() {
            return ret;
        }

        public void setRet(Long ret) {
            this.ret = ret;
        }

        public String getDsp() {
            return dsp;
        }

        public void setDsp(String dsp) {
            this.dsp = dsp;
        }

        public Item(Long ret, String dsp) {
            this.ret = ret;
            this.dsp = dsp;
        }

        @Override
        public String toString() {
            return "Item{" +
                    "ret=" + ret +
                    ", dsp='" + dsp + '\'' +
                    '}';
        }

}
