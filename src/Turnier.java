public class Turnier {
    private String name;
    private int runden;
    private int spieler;

    public Turnier() {
    }

    public Turnier(String name, int runden, int spieler) {
        this.name = name;
        this.runden = runden;
        this.spieler = spieler;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRunden() {
        return this.runden;
    }

    public void setRunden(int runden) {
        this.runden = runden;
    }

    public int getSpieler() {
        return this.spieler;
    }

    public void setSpieler(int spieler) {
        this.spieler = spieler;
    }

    public Paar calc(int[] arr, int count) {
        int ac = 0;
        int bc = 0;
        int half = arr.length / 2;
        int[] a = new int[half];
        int[] b = new int[half];

        label36:
        for(int i = 0; i < arr.length; ++i) {
            if (i < half) {
                a[ac] = arr[i];
                ++ac;
            } else {
                if (bc == half - count && count != 0) {
                    i = half;
                    int z = 0;

                    while(true) {
                        if (z >= count || bc > half) {
                            break label36;
                        }

                        b[bc] = arr[i + z];
                        ++bc;
                        ++z;
                    }
                }

                b[bc] = arr[i + count];
                ++bc;
                if (bc == half) {
                    break;
                }
            }
        }

        Paar paar = new Paar(a, b);
        return paar;
    }
}
