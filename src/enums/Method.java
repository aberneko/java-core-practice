package enums;

class Method {  // values()

    enum TeaType {
        BLACK,
        GREEN,
        WHITE,
        OOLONG,
        HERBAL
    }

    static void main() {
        for (TeaType type: TeaType.values()){  // values()
            System.out.println(type);
        }

        System.out.println(TeaType.valueOf("BLACK")); // valuesOf()


        TeaType teaType = TeaType.GREEN; // name();

        System.out.println(teaType);
        System.out.println(teaType.name());
        System.out.println(teaType.toString());
    }
}
