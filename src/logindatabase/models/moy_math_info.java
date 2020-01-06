/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logindatabase.models;

import java.math.BigDecimal;

/**
 *
 * @author mdami
 */
public class moy_math_info {

    private BigDecimal id_std;
    private float moy_math;
    private float moy_info;
    private boolean sp;
    private boolean eq;

    public boolean isSp() {
        return sp;
    }

    public boolean isEq() {
        return eq;
    }

    public moy_math_info(BigDecimal id_std, float moy_math, float moy_info) {
        this.id_std = id_std;
        this.moy_math = moy_math;
        this.moy_info = moy_info;
        this.sp = (this.moy_math > this.moy_info);
        this.eq = (this.moy_math == this.moy_info);
    }

    public BigDecimal getId_std() {
        return id_std;
    }

    public void setId_std(BigDecimal id_std) {
        this.id_std = id_std;
    }

    public float getMoy_math() {
        return moy_math;
    }

    public void setMoy_math(float moy_math) {
        this.moy_math = moy_math;
    }

    public float getMoy_info() {
        return moy_info;
    }

    public void setMoy_info(float moy_info) {
        this.moy_info = moy_info;
    }

}
