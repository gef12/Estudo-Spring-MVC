/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufv.caf.colmeia.projetointerdisciplinar.util.address;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.util.ArrayList;
import org.xml.sax.SAXException;

public class buscaCEP {

    public static ArrayList<String> getEndereco(String CEP) {
        ArrayList<String> dados = new ArrayList<>();
        try {
            URL url = new URL("https://viacep.com.br/ws/" + CEP + "/xml/");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            InputStream content = connection.getInputStream();
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder;
            dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(content);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("xmlcep");
            connection.disconnect();
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    dados.add(eElement.getElementsByTagName("cep").item(0).getTextContent());
                    dados.add(eElement.getElementsByTagName("logradouro").item(0).getTextContent());
                    dados.add(eElement.getElementsByTagName("bairro").item(0).getTextContent());
                    dados.add(eElement.getElementsByTagName("localidade").item(0).getTextContent());
                    dados.add(eElement.getElementsByTagName("uf").item(0).getTextContent());

                }
                return dados;
            }
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            return null;
        } catch (NullPointerException e) {
            return null;

        }
        return dados;
    }

}
