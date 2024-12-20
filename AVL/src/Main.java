public class Main {

    public static void main(String[] args) {
        AVL<Integer, String> st = new AVL<Integer, String>();

        //		st.put(30, "Apple"); st.put(40, "Grape");st.put(100, "Lime");
        //		st.put(20, "Mango"); st.put(10, "Strawberry");st.put(60, "Banana");
        //		st.put(70, "Cherry"); st.put(120, "Watermelon");st.put(110, "Melon");
        st.put(75, "Apple"); st.put(80, "Grape");st.put(85, "Lime");
        st.put(20, "Mango"); st.put(10, "Strawberry");st.put(50, "Banana");
        st.put(30, "Cherry");st.put(40, "Watermelon");st.put(70, "Melon"); st.put(90, "fruit");
        st.print(st.root);
        st.del(20);st.del(85);st.del(90);st.print(st.root) ;

    }
}