package Projeto.Cafeteria.aplicacao;

import cafeteria.adicionais.Cookie;
import cafeteria.adicionais.LeiteNinho;
import cafeteria.adicionais.GelodeCremedeLeite;
import cafeteria.adicionais.CanelaPo;
import cafeteria.adicionais.ChocolatePo;
import cafeteria.adicionais.RaspasdeLimao;
import cafeteria.adicionais.LeiteCondensado;
import cafeteria.bebidas.Cafe;
import cafeteria.bebidas.CafecomLeite;
import cafeteria.bebidas.EspressoPanna;
import cafeteria.bebidas.LeitecomChocolate;
import cafeteria.bebidas.Mocha;
import java.util.Scanner;
import java.util.ArrayList;
/**
 *
 * @author Henrique
 */

public class PreparativodaBebida {
    
    private int op;
    private double totalValue;
    private double valueBebidas;
    private int validator = 1;
    private ArrayList<String> adicionais = new ArrayList();
    private ArrayList<String> bebidas = new ArrayList();

    public void selectBebidas(int op) {
        switch (op) {
            case 0:
                break;
            case 1:
                Cafe cafe = new Cafe();
                cafe.prepareCafe();
                valueBebidas = cafe.getValue();
                bebidas.add("Cafe");
                break;
            case 2:
                CafecomLeite cafecomleite = new CafecomLeite();
                cafecomleite.prepareCafecomLeite();
                valueBebidas = cafecomleite.getValue();
                bebidas.add("Café com Leite");
                break;
            case 3:
                LeitecomChocolate leitecomchocolate = new LeitecomChocolate();
                leitecomchocolate.prepareLeiteChocolate();
                valueBebidas = leitecomchocolate.getValue();
                bebidas.add("Leite com Chocolate");
                break;
            case 4:
                Mocha mocha = new Mocha();
                mocha.prepareMocha();
                valueBebidas = mocha.getValue();
                bebidas.add("Mocha");
                break;
            case 5:
                EspressoPanna espressoPanna = new EspressoPanna();
                espressoPanna.prepareEspressoPanna();
                valueBebidas = espressoPanna.getValue();
                bebidas.add("Espresso Panna");
                break;
        }
    }

    public void selectSize(int op) {
        switch (op) {
            case 1:
                totalValue = valueBebidas;
                break;
            case 2:
                totalValue = (valueBebidas * 0.2) + valueBebidas;
                break;
            case 3:
                totalValue = (valueBebidas * 0.35) + valueBebidas;
                break;
        }
    }

    public void selectAdicionais() {
        Scanner sc = new Scanner(System.in);

        System.out.println("SELECIONE UM ADICIONAL");
        System.out.println("[0] - Apertei errado, nao quero adicional");
        System.out.println("[1] - Raspas de Limao");
        System.out.println("[2] - Canela em Po");
        System.out.println("[3] - Leite Ninho - Colher");
        System.out.println("[4] - Gelo de Creme de Leite - Cubo)");
        System.out.println("[5] - Leite Condensado - Colher");
        System.out.println("[6] - Chocolate em Po - Colher");
        System.out.println("[7] - Cookie - Unidade");
        System.out.println("Seleciona uma opção do adicional: ");
        op = sc.nextInt();
        switch (op) {
            case 1:
                RaspasdeLimao raspasdelimao = new RaspasdeLimao();
                raspasdelimao.prepareRaspasdeLimao();
                totalValue += raspasdelimao.getValue();
                adicionais.add("Raspas de Limao");
                break;
            case 2:
                CanelaPo canelapo = new CanelaPo();
                canelapo.prepareCanelaPo();
                totalValue += canelapo.getValue();
                adicionais.add("Canela em Po");
                break;
            case 3:
                LeiteNinho leiteninho = new LeiteNinho();
                leiteninho.prepareLeiteNinho();
                totalValue += leiteninho.getValue();
                adicionais.add("Leite Ninho - Colher");
                break;
            case 4:
                GelodeCremedeLeite gelodecremedeleite = new GelodeCremedeLeite();
                gelodecremedeleite.prepareGelodeCremedeLeite();
                totalValue += gelodecremedeleite.getValue();
                adicionais.add("Gelo de creme de Leite - Cubo");
                break;
            case 5:
                LeiteCondensado leitecondensado = new LeiteCondensado();
                leitecondensado.prepareLeiteCondensado();
                totalValue += leitecondensado.getValue();
                adicionais.add("Leite Condensado - Colher");
                break;
            case 6:
                ChocolatePo chocolatepo = new ChocolatePo();
                chocolatepo.prepareChocolatePo();
                totalValue += chocolatepo.getValue();
                adicionais.add("Chocolate em Po - Colher");
                break;
            case 7:
                Cookie cookie = new Cookie();
                cookie.prepareCookie();
                totalValue += cookie.getValue();
                adicionais.add("Cookie - Unidade");
                break;
        }
    }

    public void maisAdicionais() {
        Scanner sc = new Scanner(System.in);
        while (validator == 1) {
            System.out.println("Adquirir adicional?");
            System.out.println("[1] - Sim");
            System.out.println("[2] - Nao");
            validator(sc.nextInt());
        }

    }

    private void validator(int op) {
        switch (op) {
            case 1:
                selectAdicionais();
                break;
            case 2:
                validator -= 1;
                break;
        }

    }

    public double getTotalValue() {
        return totalValue;
    }

    public ArrayList<String> getAdicionais() {
        return adicionais;
    }

    public ArrayList<String> getBebidas() {
        return bebidas;
    } 
}
