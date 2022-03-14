<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="Start.aspx.cs" Inherits="StudArch.Start" MasterPageFile="Site.Master" %>
<asp:Content ID="MainContent" ContentPlaceHolderID="ContentPlaceHolder1" runat="server">
    <asp:GridView ID="GridView1" runat="server" AllowSorting="True" AutoGenerateColumns="False" CellPadding="4" DataSourceID="SqlDataSource1" ForeColor="#333333" GridLines="None">
    <AlternatingRowStyle BackColor="White" ForeColor="#284775" />
    <Columns>
        <asp:BoundField DataField="Stud_id" HeaderText="Stud_id" SortExpression="Stud_id" />
        <asp:BoundField DataField="Name" HeaderText="Name" SortExpression="Name" />
        <asp:BoundField DataField="Surname" HeaderText="Surname" SortExpression="Surname" />
        <asp:BoundField DataField="Subject" HeaderText="Subject" SortExpression="Subject" />
        <asp:BoundField DataField="Grade" HeaderText="Grade" SortExpression="Grade" />
    </Columns>
    <EditRowStyle BackColor="#999999" />
    <FooterStyle BackColor="#5D7B9D" Font-Bold="True" ForeColor="White" />
    <HeaderStyle BackColor="#5D7B9D" Font-Bold="True" ForeColor="White" />
    <PagerStyle BackColor="#284775" ForeColor="White" HorizontalAlign="Center" />
    <RowStyle BackColor="#F7F6F3" ForeColor="#333333" />
    <SelectedRowStyle BackColor="#E2DED6" Font-Bold="True" ForeColor="#333333" />
    <SortedAscendingCellStyle BackColor="#E9E7E2" />
    <SortedAscendingHeaderStyle BackColor="#506C8C" />
    <SortedDescendingCellStyle BackColor="#FFFDF8" />
    <SortedDescendingHeaderStyle BackColor="#6F8DAE" />
</asp:GridView>
<asp:SqlDataSource ID="SqlDataSource1" runat="server" ConnectionString="<%$ ConnectionStrings:StudArch %>" SelectCommand="SELECT * FROM [NameResults]"></asp:SqlDataSource>
</asp:Content>


        
 