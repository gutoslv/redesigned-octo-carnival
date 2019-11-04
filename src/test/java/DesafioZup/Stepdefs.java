package DesafioZup;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import org.openqa.selenium.By;
import pageObject.BasePage;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class Stepdefs {
  private String produto = "iphone 11";

  @Dado("que estou na página inicial do sistema")
  public void que_estou_na_página_inicial_do_sistema() {
    BasePage.navigateToUrl("https://www.magazineluiza.com.br/");
    assertThat(BasePage.getCurrentUrl(), is(equalTo("https://www.magazineluiza.com.br/")));
  }

  @Quando("busco por um produto")
  public void busco_por_um_produto() {
    BasePage.setText(By.cssSelector("#inpHeaderSearch"), produto);
    BasePage.clickElement(By.cssSelector("#btnHeaderSearch"));
  }

  @Então("o retorno da busca mostra o produto")
  public void o_retorno_da_busca_mostra_o_produto() {
    assertThat(BasePage.getText(By.xpath("//h1[@id='main-title']//strong")), is(equalTo(produto)));
  }

  @Dado("que estou na tela com os resultados de uma busca")
  public void que_estou_na_tela_com_os_resultados_de_uma_busca() {
    BasePage.navigateToUrl("https://busca.magazineluiza.com.br/busca?q=iphone+11");
    assertThat(BasePage.getCurrentUrl(), is(equalTo("https://busca.magazineluiza.com.br/busca?q=iphone+11")));
  }

  @Quando("clico em um produto")
  public void clico_em_um_produto() {
    BasePage.clickElement(By.xpath("//a//img[@class='nm-product-img']"));
  }

  @Então("sou enviado para a tela do produto")
  public void sou_enviado_para_a_tela_do_produto() {
    assertThat(BasePage.isElementOnPage(By.xpath("//button[@class='button__buy " +
        "button__buy-product-detail js-add-cart-button js-main-add-cart-button " +
        "js-add-box-prime']")), is(equalTo(true)));
  }

  @Dado("que estou na página de um produto")
  public void que_estou_na_página_de_um_produto() {
    BasePage.navigateToUrl("https://www.magazineluiza.com" +
        ".br/iphone-11-apple-256gb-preto-4g-tela-61-retina-camera-dupla-12mp-selfie-12mp-ios-13/p" +
        "/155561800/te/teip/");
    assertThat(BasePage.isElementOnPage(By.xpath("//button[@class='button__buy " +
        "button__buy-product-detail js-add-cart-button js-main-add-cart-button " +
        "js-add-box-prime']")), is(equalTo(true)));
  }

  @Quando("clico em adicionar produto ao carrinho de compras")
  public void clico_em_adicionar_produto_ao_carrinho_de_compras() {
    BasePage.clickElement(By.xpath("//button[@class='button__buy button__buy-product-detail " +
        "js-add-cart-button js-main-add-cart-button js-add-box-prime']"));
  }

  @Então("o produto é adicionado no carrinho de compras")
  public void o_produto_é_adicionado_no_carrinho_de_compras() {
    assertThat(BasePage.isElementOnPage(By.xpath("//a[@class='BasketPriceBox-continue-buyMore']")),
        is(equalTo(true)));
    assertThat(BasePage.getText(By.xpath("//span[@class='BasketItem-product-info-sku']")),
        is(equalTo("Código do produto: 155561800")));
  }
}
