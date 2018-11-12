public class Move {
    int type;
    int x;
    int y;
    char a;
    char b;

    public Move(String s) {
        switch (s.charAt(0)) {
            case 's': {
                type = 0;
                x = Integer.parseInt(s.split("s")[1]);
                break;
            }
            case 'x': {
                this.type = 1;
                this.x = Integer.parseInt(s.split("/")[0].substring(1));
                this.y = Integer.parseInt(s.split("/")[1]);
                // this.x = s.charAt(1) - '0';
                // this.y = s.charAt(3) - '0';
                break;
            }
            case 'p': {
                this.type = 2;
                this.a = s.split("/")[0].substring(1).charAt(0);
                this.b = s.split("/")[1].charAt(0);
                //this.a = s.charAt(1);
                //this.b = s.charAt(3);
                break;
            }
        }
    }
}
