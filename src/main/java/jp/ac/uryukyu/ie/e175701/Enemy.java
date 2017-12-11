package jp.ac.uryukyu.ie.e175701;

public class Enemy extends LivingThing {

    public Enemy(String name, int maximumHP, int attack) {
        super(name, maximumHP, attack);
    }

    public void wounded(int damage){
        setHitPoint(getHitPoint()-damage);
        if( getHitPoint() < 0 ) {
            setDead(true);
            System.out.printf("モンスター%sは倒れた。\n", getName());
        }
    } public void attack(LivingThing par) {
        if (!isDead()) {
            int damage = (int) (Math.random() * getAttack());
            int l = (int) (Math.random() * 100);
            if (l <= 30 && damage > 0) {
                damage = damage * 2;
                System.out.printf("%sの攻撃！痛恨の一撃！！%sに%dのダメージを与えた！！\n", getName(), par.getName(), damage);
                par.wounded(damage);
            } else {
                switch (damage) {
                    case 0:
                        System.out.printf("%sの攻撃！,,,だが、%sは攻撃を回避した！\n", getName(), par.getName(), damage);
                        break;
                    default:
                        System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", getName(), par.getName(), damage);
                        par.wounded(damage);
                }
            }
        }
    }
}
