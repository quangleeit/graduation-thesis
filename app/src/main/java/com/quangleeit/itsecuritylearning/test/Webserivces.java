package com.quangleeit.itsecuritylearning.test;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Franky on 4/27/2017.
 */

public class Webserivces {

    private final String NAME_SPACE = "http://tempuri.org/";

    private final String METHOD_NAME = "getListCatalog";
    private final String SOAP_ACTION = NAME_SPACE + METHOD_NAME;

    private final String METHOD_NAME2 = "getListProductByCatalogId";
    private final String SOAP_ACTION2 = NAME_SPACE + METHOD_NAME2;


    private final String URL = "http://192.168.100.14/WebSite2/WebService.asmx?WSDL";
    ArrayList<Cate> listCate;
    ArrayList<Product> listProduct;

    public List<Cate> getListCatalog() {

        listCate = new ArrayList<Cate>();
        SoapObject request = new SoapObject(NAME_SPACE, METHOD_NAME);

        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);

        envelope.dotNet = true;

        envelope.setOutputSoapObject(request);

        HttpTransportSE httpTransportSE = new HttpTransportSE(URL);

        try {
            httpTransportSE.call(SOAP_ACTION, envelope);

            SoapObject arrObject = (SoapObject) envelope.getResponse();


            for (int i = 0; i < arrObject.getPropertyCount(); i++) {
                SoapObject itemObject = (SoapObject) arrObject.getProperty(i);


                String scateId = itemObject.getProperty("CateId").toString();
                int cateId = Integer.parseInt(scateId);
                String cateName = itemObject.getProperty("CateName").toString();
                //đẩy vào array
                Cate c = new Cate(cateId, cateName);

                listCate.add(c);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }

        return listCate;
    }

    public ArrayList<Cate> getArray() {
        return listCate;
    }

    public List<Product> getListProductByCatalogId(int cateId) {

        listProduct = new ArrayList<Product>();
        try {
            SoapObject request = new SoapObject(NAME_SPACE, METHOD_NAME2);
            request.addProperty("id", cateId);

            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);

            envelope.dotNet = true;

            envelope.setOutputSoapObject(request);

            HttpTransportSE httpTransportSE = new HttpTransportSE(URL);


            httpTransportSE.call(SOAP_ACTION2, envelope);

            SoapObject arrObject = (SoapObject) envelope.getResponse();


            for (int i = 0; i < arrObject.getPropertyCount(); i++) {
                SoapObject soapItem = (SoapObject) arrObject.getProperty(i);

                String sproductId = soapItem.getProperty("ProductId").toString();
                int productId = Integer.parseInt(sproductId);
                String productName = soapItem.getProperty("ProductName").toString();
                String squantity = soapItem.getProperty("Quantity").toString();
                String sunitPrice = soapItem.getProperty("UnitPrice").toString();

                int quantity = Integer.parseInt(squantity);
                double unitPrice = Double.parseDouble(sunitPrice);

                //đẩy vào array
                Product p = new Product(productId, productName, quantity, unitPrice);


                listProduct.add(p);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }

        return listProduct;
    }


}
