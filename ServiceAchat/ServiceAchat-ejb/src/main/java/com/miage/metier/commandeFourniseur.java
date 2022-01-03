/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miage.metier;

/**
 *
 * @author Mohamed-AmineBouhadj
 */
class commandeFourniseur {
        private int id;
        private String[] commandeC;

        public int getId() {
                return id;
        }

        public void setId(int id) {
                this.id = id;
        }

        public String[] getCommandeC() {
                return commandeC;
        }

        public void setCommandeC(String[] commandeC) {
                this.commandeC = commandeC;
        }

        public commandeFourniseur( String[] commandeC) {
                this.id = id;
                this.commandeC = commandeC;
        }
        
}
