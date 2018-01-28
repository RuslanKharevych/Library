<%@ page import="beans.Book" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="enums.SearchType" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@include file="../WEB-INF/jspf/left_menu.jspf" %>

<jsp:useBean id="bookList" class="beans.BookList" scope="page"/>

<%@include file="../WEB-INF/jspf/letter.jspf" %>

<div class="book_list">

    <%
        ArrayList<Book> list = new ArrayList<Book>();

        if (request.getParameter("genre_id") != null) {
            int genreId = Integer.valueOf(request.getParameter("genre_id"));
            list = bookList.getBooksByGenre(genreId);
            System.out.println("1");
        }
        else if (request.getParameter("letter") != null) {
            String letter = request.getParameter("letter");
            list = bookList.getBooksByLetter(letter);
            System.out.println("2");
        }
        else if (request.getParameter("searchString") != null) {
            String searchStr = request.getParameter("searchString");
            SearchType type = SearchType.TITLE;
            if (request.getParameter("search_option").equals("Автор")) {
                type = SearchType.AUTHOR;
            }
            System.out.println("3");

            if (searchStr != null && !searchStr.trim().equals("")) {
                list = bookList.getBooksBySearch(searchStr, type);
                System.out.println("4");
            }
        }
    %>
    <h5 style="text-align: left; margin-top:20px;">Знайдено книг: <%=list.size() %> </h5>
    <%
        System.out.println("5");
        session.setAttribute("currentBookList", list);
        for (Book book : list) {

    %>

    <div class="book_info">
        <div class="book_image">
            <img src="../images/<%=book.getImage()%>" alt="Photo"/>
            <div class="read-button">
                <a href="#">Читати</a>
            </div>
        </div>
        <div class="book_details">
            <br><strong>Назва</strong> <%=book.getBook()%>
            <br><strong>Видавництво:</strong> <%=book.getPublisher()%>
            <br><strong>Рік видавництва:</strong> <%=book.getYear()%>
            <br><strong>Автор:</strong> <%=book.getAuthor()%>
        </div>
    </div>


    <%}%>
</div>

