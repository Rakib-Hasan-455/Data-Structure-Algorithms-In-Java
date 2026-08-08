class InsertDeleteReplace {
    public static void main(String[] args) {
        insert("Rakib", "Sakib");
        delete("Rakib", "ak");
        update("Rakib", "ak", "al");
    }

    static void insert(String s1, String s2) {
        StringBuffer sb = new StringBuffer();
        sb.append(s1);
        sb.append(s2);
        System.out.println("After Inserted = " + sb);
        sb.insert(0, s2);
        System.out.println("After Inserted = " + sb);
    }

    static void delete(String strA, String strB) {
        int pos = strA.indexOf(strB);
        if (pos != -1) {
            StringBuilder strC = new StringBuilder();
            strC.append(strA, 0, pos);
            strC.append(strA.substring(pos + strB.length()));
            System.out.println("After Deleted = " + strC);
        }
    }

    static void update(String strA, String strB, String strC) {
        int pos = strA.indexOf(strB);
        if (pos != -1) {
            StringBuilder strD = new StringBuilder();
            strD.append(strA, 0, pos);
            strD.append(strC);
            strD.append(strA.substring(pos + strB.length()));
            System.out.println("After Updated = " + strD);
        }
    }
}