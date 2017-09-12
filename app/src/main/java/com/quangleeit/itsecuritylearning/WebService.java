package com.quangleeit.itsecuritylearning;

import com.quangleeit.itsecuritylearning.courses.ItemCourse;
import com.quangleeit.itsecuritylearning.interview.ItemInterviewQuestion;
import com.quangleeit.itsecuritylearning.lesson.ItemLesson;
import com.quangleeit.itsecuritylearning.question.ItemQuestion;
import com.quangleeit.itsecuritylearning.student.Student;
import com.quangleeit.itsecuritylearning.teacher.ItemTeacher;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.Marshal;
import org.ksoap2.serialization.MarshalFloat;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Franky on 27/03/2017.
 */

public class WebService {
    private final String NAME_SPACE = "http://tempuri.org/";

    private final String METHOD_NAME_ID_TEACHER = "getIdTeacher";
    private final String SOAP_ACTION_ID_TEACHER  = NAME_SPACE + METHOD_NAME_ID_TEACHER;

    private final String METHOD_NAME_TEACHER_LIST = "getListTeacher";
    private final String SOAP_ACTION_TEACHER_LIST  = NAME_SPACE + METHOD_NAME_TEACHER_LIST;

    private final String METHOD_NAME_TEACHER = "getTeacher";
    private final String SOAP_ACTION_TEACHER  = NAME_SPACE + METHOD_NAME_TEACHER;

    private final String METHOD_NAME_COURSE_LIST = "getListCourse";
    private final String SOAP_ACTION_COURSE_LIST  = NAME_SPACE + METHOD_NAME_COURSE_LIST;

    private final String METHOD_NAME_COURSE = "getCourse";
    private final String SOAP_ACTION_COURSE  = NAME_SPACE + METHOD_NAME_COURSE;

    private final String METHOD_NAME_LESSON_LIST = "getListLessonByCourseId";
    private final String SOAP_ACTION_LESSON_LIST  = NAME_SPACE + METHOD_NAME_LESSON_LIST;

    private final String METHOD_NAME_LESSON = "getLesson";
    private final String SOAP_ACTION_LESSON  = NAME_SPACE + METHOD_NAME_LESSON;

    private final String METHOD_NAME_QUESTIONANSWER_LIST = "getListQuestionAnswerByCourseId";
    private final String SOAP_ACTION_QUESTIONANSWER_LIST  = NAME_SPACE + METHOD_NAME_QUESTIONANSWER_LIST;

    private final String METHOD_NAME_QUESTIONANSWER = "getQuestionAnswer";
    private final String SOAP_ACTION_QUESTIONANSWER  = NAME_SPACE + METHOD_NAME_QUESTIONANSWER;

    private final String METHOD_NAME_QUESTIONCHOICE_LIST = "getListQuestionChoiceByCourseId";
    private final String SOAP_ACTION_QUESTIONCHOICE_LIST  = NAME_SPACE + METHOD_NAME_QUESTIONCHOICE_LIST;

    private final String METHOD_NAME_QUESTIONCHOICE = "getQuestionChoice";
    private final String SOAP_ACTION_QUESTIONCHOICE  = NAME_SPACE + METHOD_NAME_QUESTIONCHOICE;

    private final String METHOD_LOGIN = "checkLogin";
    private final String SOAP_ACTION_LOGIN = NAME_SPACE + METHOD_LOGIN;

    private final String METHOD_REGISTER = "addNewAccount";
    private final String SOAP_ACTION_REGISTER = NAME_SPACE + METHOD_REGISTER;

    private final String URL = "http://192.168.100.15/MostyWebService/WebService.asmx?WSDL";

    private ArrayList<ItemTeacher> listTeacher;
    private ArrayList<ItemCourse> listCourse;
    private ArrayList<ItemLesson> listLesson;
    private ArrayList<ItemInterviewQuestion> listQuestionAnswer;
    private ArrayList<ItemQuestion> listQuestionChoice;


    public int checkLogin(String username, String password){
        int check = -1;
        SoapObject request = new SoapObject(NAME_SPACE, METHOD_LOGIN);
        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        envelope.dotNet = true;

        request.addProperty("username", username);
        request.addProperty("password", password);


        envelope.setOutputSoapObject(request);

        Marshal marshal = new MarshalFloat();
        marshal.register(envelope);

        HttpTransportSE httpTransportSE = new HttpTransportSE(URL);

        try {
            httpTransportSE.call(SOAP_ACTION_LOGIN, envelope);

            SoapPrimitive item = (SoapPrimitive) envelope.getResponse();
            String a = item.toString();

            check = Integer.parseInt(a);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }


        return check;
    }

    public int addNewAcount(Student student){
        int check = 0;

        SoapObject request = new SoapObject(NAME_SPACE, METHOD_REGISTER);
        SoapObject newAcount = new SoapObject(NAME_SPACE, "ac");

        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        envelope.dotNet = true;

        newAcount.addProperty("Username", student.getUsername().toString());
        newAcount.addProperty("Fullname", student.getFullName().toString());


        newAcount.addProperty("Password", student.getPassword().toString());
        newAcount.addProperty("Email", student.getEmail().toString());

        request.addSoapObject(newAcount);

        MarshalFloat marshalFloat = new MarshalFloat();
        marshalFloat.register(envelope);

        envelope.setOutputSoapObject(request);

        HttpTransportSE httpTransportSE = new HttpTransportSE(URL);

        try {
            httpTransportSE.call(SOAP_ACTION_REGISTER, envelope);
            SoapPrimitive item = (SoapPrimitive) envelope.getResponse();

            String value = item.toString();

            check = Integer.parseInt(value);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }

        return check;
    }

    public int getIdTecher(int idCourse){
//        ItemTeacher itemTeacher = null;
        int idTeacher = 0;
        SoapObject request = new SoapObject(NAME_SPACE, METHOD_NAME_ID_TEACHER);

        request.addProperty("id", idCourse);

        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);

        envelope.dotNet = true;

        envelope.setOutputSoapObject(request);

        HttpTransportSE httpTransportSE = new HttpTransportSE(URL);

        try {
            httpTransportSE.call(SOAP_ACTION_ID_TEACHER, envelope);

            //SoapObject arrObject = (SoapObject) envelope.getResponse();

            SoapObject itemObject = (SoapObject) envelope.getResponse();

            String mteacherId = itemObject.getProperty("IdTeacher").toString();
            idTeacher = Integer.parseInt(mteacherId);
//            String teacherName = itemObject.getProperty("Fullname").toString();
//            String email = itemObject.getProperty("Email").toString();

//            itemTeacher =  new ItemTeacher(teacherId, teacherName, email);


        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }

        return idTeacher;
    }

    public List<ItemTeacher> getListTeacher() {

        listTeacher = new ArrayList<ItemTeacher>();

        SoapObject request = new SoapObject(NAME_SPACE, METHOD_NAME_TEACHER_LIST);

        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);

        envelope.dotNet = true;

        envelope.setOutputSoapObject(request);

        HttpTransportSE httpTransportSE = new HttpTransportSE(URL);

        try {
            httpTransportSE.call(SOAP_ACTION_TEACHER_LIST, envelope);

            SoapObject arrObject = (SoapObject) envelope.getResponse();

            for (int i = 0; i < arrObject.getPropertyCount(); i++) {
                SoapObject itemObject = (SoapObject) arrObject.getProperty(i);

                String mteacherId = itemObject.getProperty("IdTeacher").toString();
                int teacherId = Integer.parseInt(mteacherId);
                String teacherName = itemObject.getProperty("Fullname").toString();
                String email = itemObject.getProperty("Email").toString();

                ItemTeacher itemTeacher =  new ItemTeacher(teacherId, teacherName, email);
                listTeacher.add(itemTeacher);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }

        return listTeacher;
    }

    public ArrayList<ItemTeacher> getArrayTeacher() {
        return listTeacher;
    }

    public List<ItemCourse> getListCourse() {

        listCourse = new ArrayList<ItemCourse>();

        SoapObject request = new SoapObject(NAME_SPACE, METHOD_NAME_COURSE_LIST);

        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);

        envelope.dotNet = true;

        envelope.setOutputSoapObject(request);

        HttpTransportSE httpTransportSE = new HttpTransportSE(URL);

        try {
            httpTransportSE.call(SOAP_ACTION_COURSE_LIST, envelope);

            SoapObject arrObject = (SoapObject) envelope.getResponse();

            for (int i = 0; i < arrObject.getPropertyCount(); i++) {
                SoapObject itemObject = (SoapObject) arrObject.getProperty(i);

                String mcourseId = itemObject.getProperty("IdCourse").toString();
                int courseId = Integer.parseInt(mcourseId);
                String courseName = itemObject.getProperty("NameCourse").toString();
                //đẩy vào array
                ItemCourse itemCourse = new ItemCourse(courseId, courseName);
                listCourse.add(itemCourse);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }

        return listCourse;
    }

    public ArrayList<ItemCourse> getArray() {
        return listCourse;
    }

    public List<ItemLesson> getListLessonByCourseId(int courseId) {

        listLesson = new ArrayList<ItemLesson>();

        try {
            SoapObject request = new SoapObject(NAME_SPACE, METHOD_NAME_LESSON_LIST);

            request.addProperty("id", courseId);

            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);

            envelope.dotNet = true;

            envelope.setOutputSoapObject(request);

            HttpTransportSE httpTransportSE = new HttpTransportSE(URL);

            httpTransportSE.call(SOAP_ACTION_LESSON_LIST, envelope);

            SoapObject arrObject = (SoapObject) envelope.getResponse();

            for (int i = 0; i < arrObject.getPropertyCount(); i++) {
                SoapObject soapItem = (SoapObject) arrObject.getProperty(i);

                String mlessonId = soapItem.getProperty("IdLesson").toString();
                int lessonId = Integer.parseInt(mlessonId);
                String lessonTitle = soapItem.getProperty("Title").toString();
                String lessonContent = soapItem.getProperty("ContentLesson").toString();

                //đẩy vào array
                ItemLesson lesson = new ItemLesson(lessonId, lessonTitle, lessonContent);
                listLesson.add(lesson);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }

        return listLesson;
    }

    public List<ItemInterviewQuestion> getListQuestionAnswerByCourseId(int courseId) {

        listQuestionAnswer = new ArrayList<>();

        try {
            SoapObject request = new SoapObject(NAME_SPACE, METHOD_NAME_QUESTIONANSWER_LIST);

            request.addProperty("id", courseId);

            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);

            envelope.dotNet = true;

            envelope.setOutputSoapObject(request);

            HttpTransportSE httpTransportSE = new HttpTransportSE(URL);

            httpTransportSE.call(SOAP_ACTION_QUESTIONANSWER_LIST, envelope);

            SoapObject arrObject = (SoapObject) envelope.getResponse();

            for (int i = 0; i < arrObject.getPropertyCount(); i++) {
                SoapObject soapItem = (SoapObject) arrObject.getProperty(i);

                String mquestId = soapItem.getProperty("IdQuestionAnswer").toString();
                int questId = Integer.parseInt(mquestId);
                String contentQuest = soapItem.getProperty("Question").toString();
                String answerQuest = soapItem.getProperty("Answer").toString();

                //đẩy vào array
                ItemInterviewQuestion itemInterviewQuestion = new ItemInterviewQuestion(questId, contentQuest, answerQuest);
                listQuestionAnswer.add(itemInterviewQuestion);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }

        return listQuestionAnswer;
    }

    public List<ItemQuestion> getListQuestionChoiceByCourseId(int courseId) {

        listQuestionChoice = new ArrayList<>();

        try {
            SoapObject request = new SoapObject(NAME_SPACE, METHOD_NAME_QUESTIONCHOICE_LIST);

            request.addProperty("id", courseId);

            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);

            envelope.dotNet = true;

            envelope.setOutputSoapObject(request);

            HttpTransportSE httpTransportSE = new HttpTransportSE(URL);

            httpTransportSE.call(SOAP_ACTION_QUESTIONCHOICE_LIST, envelope);

            SoapObject arrObject = (SoapObject) envelope.getResponse();

            for (int i = 0; i < arrObject.getPropertyCount(); i++) {
                SoapObject soapItem = (SoapObject) arrObject.getProperty(i);

                String mquestId = soapItem.getProperty("IdQuestionChoice").toString();
                int questId = Integer.parseInt(mquestId);
                String contentQuest = soapItem.getProperty("ContentQuestion").toString();
                String answerA = soapItem.getProperty("AnswerA").toString();
                String answerB = soapItem.getProperty("AnswerB").toString();
                String answerC = soapItem.getProperty("AnswerC").toString();
                String answerD = soapItem.getProperty("AnswerD").toString();
                int trueAnswer = Integer.parseInt(soapItem.getProperty("TruQuestion").toString());
                int difficult = Integer.parseInt(soapItem.getProperty("Difficult").toString());
                //đẩy vào array
                ItemQuestion itemQuestion = new ItemQuestion(questId, contentQuest, answerA, answerB, answerC, answerD, trueAnswer, difficult);
                listQuestionChoice.add(itemQuestion);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }

        return listQuestionChoice;
    }

    public ItemLesson getLesson(int id){
       // ItemLesson itemLesson = new ItemLesson(2, "Qa", "d");
        ItemLesson itemLesson = null;
        SoapObject request = new SoapObject(NAME_SPACE, METHOD_NAME_LESSON);

        request.addProperty("id", id);

        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);

        envelope.dotNet = true;

        envelope.setOutputSoapObject(request);

        HttpTransportSE httpTransportSE = new HttpTransportSE(URL);

        try {
            httpTransportSE.call(SOAP_ACTION_LESSON, envelope);

            //SoapObject arrObject = (SoapObject) envelope.getResponse();


            SoapObject soapItem = (SoapObject) envelope.getResponse();
            String mlessonId = soapItem.getProperty("IdLesson").toString();
            int lessonId = Integer.parseInt(mlessonId);
            String lessonTitle = soapItem.getProperty("Title").toString();
            String lessonContent = soapItem.getProperty("ContentLesson").toString();

            //đẩy vào array
            itemLesson = new ItemLesson(lessonId, lessonTitle, lessonContent);


        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }

        return itemLesson;
    }

    public ItemTeacher getTeacher(int id){

        ItemTeacher itemTeacher = null;
        SoapObject request = new SoapObject(NAME_SPACE, METHOD_NAME_TEACHER);

        request.addProperty("id", id);

        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);

        envelope.dotNet = true;

        envelope.setOutputSoapObject(request);

        HttpTransportSE httpTransportSE = new HttpTransportSE(URL);

        try {
            httpTransportSE.call(SOAP_ACTION_TEACHER, envelope);

            //SoapObject arrObject = (SoapObject) envelope.getResponse();

            SoapObject itemObject = (SoapObject) envelope.getResponse();

            String mteacherId = itemObject.getProperty("IdTeacher").toString();
            int teacherId = Integer.parseInt(mteacherId);
            String teacherName = itemObject.getProperty("Fullname").toString();
            String email = itemObject.getProperty("Email").toString();

            itemTeacher =  new ItemTeacher(teacherId, teacherName, email);


        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }

        return itemTeacher;
    }
}
