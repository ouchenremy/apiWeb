package com.example.projet_javafx;

public class Cle {
        private int numero;
        private String couleur;
        private String libelle;

        public Cle(int numeroCle, String couleurCle, String libelleCle) {
            this.libelle = libelleCle;
            this.couleur = couleurCle;
            this.numero = numeroCle;
        }

        public int getNumero(){

            return this.numero;
        }

        public void setNumero(int unNumero) {

            this.numero = unNumero;
        }

        public String getCouleur(){

            return this.couleur;
        }

        public void setCouleur(String uneCouleur) {

            this.couleur = uneCouleur;
        }

        public String getLibelle(){
            return this.libelle;
        }

        public void setLibelle(String unLibelle) {

            this.libelle = unLibelle;
        }

        public String toString(){
            return this.numero + " : " + this.libelle + " ("+this.couleur +")";
        }

}
