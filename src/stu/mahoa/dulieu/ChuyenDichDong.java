package stu.mahoa.dulieu;

public class ChuyenDichDong {
    //khai báo các thuộc tính
    private String text;
    private String key;
    private int[][] matran;
    private int dong;
    private int cot;
    //khởi tạo các thuộc tính
    public int getDong() {
        return dong;
    }

    public void setDong(int dong) {
        this.dong = dong;
    }

    public int getCot() {
        return cot;
    }

    public void setCot(int cot) {
        this.cot = cot;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public int[][] getMatran() {
        return matran;
    }

    public void setMatran(int[][] matran) {
        this.matran = matran;
    }

    public ChuyenDichDong(String text, String key, int[][] matran) {
        this.text = text;
        this.key = key;
        this.matran = matran;
    }

    public ChuyenDichDong() {
    }

    
    public char[][] taoMatran() {
        int dong = 0;
        int cot = this.key.length();
        if (this.text.length() % this.key.length() == 0) {
            dong = this.text.length() / this.key.length() + 1;
        } else {
            int soKyTuthem = this.key.length() - (this.text.length() % this.key.length());
            dong = this.text.length() / this.key.length() + 2;
            for (int i = 0; i < soKyTuthem; i++) {

                this.text = this.text + "x";
            }

        }
        char[][] matran = new char[dong][cot];
        this.dong = dong;
        this.cot = cot;
        return matran;
    }

    public char[][] nhapDuLieuVaoMaTran() {

        char[][] a = this.taoMatran();
        String text1 = this.key + this.text;
        char[] mangText = text1.toCharArray();
        int vt = 0;
        for (int i = 0; i < this.dong; i++) {

            for (int j = 0; j < this.cot; j++) {

                a[i][j] = mangText[vt];
                vt++;
            }
        }
        return a;

    }

    public int[][] chuyenMaTranSo(char[][] b) {
        int[][] a = new int[this.dong][this.cot];
        for (int i = 0; i < this.dong; i++) {
            for (int j = 0; j < this.cot; j++) {
                a[i][j]=(int)b[i][j];
            }

        }
        return a;
    }
    public String mahoa()
    {
        char[][] a = this.taoMatran();
        char []dulieu=this.text.toCharArray();
        int spt=0;
        String text="";
        char[]key=this.key.toCharArray();
        for (int i = 0; i < this.cot; i++) {
            a[0][i]=key[i];
        }
        for (int i = 0; i < this.cot; i++) {
             int max=0;
             for (int j = 1; j < this.cot; j++)
             {
                 if(a[0][j]>a[0][max])
                 {
                     max=j;
                 }
             }
             for (int k = 1; k < this.dong; k++) {
                 a[k][max]=dulieu[spt];
                 spt++;
             }
             a[0][max]=0;
        }
        for (int i = 1; i < this.dong; i++) {
            for (int j = 0; j < this.cot; j++) {
                text=text+a[i][j];
            }
        }
        return text;
    }
    public String xuattextSauKhiMaHoa()
    {
        String text="";
        int [][]matran=this.chuyenMaTranSo(this.nhapDuLieuVaoMaTran());
         for (int i = 0; i < this.cot; i++) {
             int max=0;
             for (int j = 1; j < this.cot; j++)
             {
                 if(matran[0][j]>matran[0][max])
                 {
                     max=j;
                 }
             }
             for (int k = 1; k < this.dong; k++) {
                 text=text+(char)matran[k][max];
             }
             matran[0][max]=0;
        }
        return text;
    }
    public void xuatmatran() {
        int a[][] = this.chuyenMaTranSo(nhapDuLieuVaoMaTran());
        for (int i = 0; i < this.dong; i++) {
            System.out.println("\n");
            for (int j = 0; j < this.cot; j++) {
                System.out.print(a[i][j] + " ");
            }
        }
    }

    public static void main(String[] args) {
        ChuyenDichDong a = new ChuyenDichDong();
        a.setText("HCBHMONUxAAAOAAGNxCOCNCHUDG");
        a.setKey("hum");
        a.xuatmatran();
        
        System.out.println(a.mahoa());
        

    }
}
