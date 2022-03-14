<%@ Page Title="" Language="C#" MasterPageFile="~/Site.Master" AutoEventWireup="true" CodeBehind="Grade.aspx.cs" Inherits="StudArch.Grade" %>
<asp:Content ID="Content1" ContentPlaceHolderID="ContentPlaceHolder1" runat="server">
    <asp:DropDownList ID="DropDownList1" runat="server" DataSourceID="SqlDataSource1" DataTextField="Column1" DataValueField="Column1" Height="30px" Width="250px">
</asp:DropDownList>
    <asp:DropDownList ID="DropDownList2" runat="server" DataSourceID="SqlDataSource3" DataTextField="Subject" DataValueField="Subject" Height="30px" Width="150px">
    </asp:DropDownList>
    <asp:DropDownList ID="DropDownList3" runat="server" DataSourceID="SqlDataSource2" DataTextField="Grade" DataValueField="Grade" Height="30px" Width="60px">
    </asp:DropDownList>
    <asp:SqlDataSource ID="SqlDataSource3" runat="server" ConnectionString="<%$ ConnectionStrings:StudArch %>" SelectCommand="SELECT * FROM [Subjects]"></asp:SqlDataSource>
    <asp:Button ID="Save" runat="server" Height="30px" OnClick="Save_Click" Text="Save" Width="60px" />
    <asp:SqlDataSource ID="SqlDataSource2" runat="server" ConnectionString="<%$ ConnectionStrings:StudArch %>" SelectCommand="SELECT [Grade] FROM [Grades]"></asp:SqlDataSource>
    <asp:GridView ID="GridView1" runat="server" AutoGenerateColumns="False" DataKeyNames="id" DataSourceID="SqlDataSource4" OnSelectedIndexChanged="GridView1_SelectedIndexChanged">
        <Columns>
            <asp:CommandField ShowSelectButton="True" />
            <asp:BoundField DataField="id" HeaderText="id" InsertVisible="False" ReadOnly="True" SortExpression="id" />
            <asp:BoundField DataField="Name" HeaderText="Name" SortExpression="Name" />
            <asp:BoundField DataField="Patronomic" HeaderText="Patronomic" SortExpression="Patronomic" />
            <asp:BoundField DataField="Surname" HeaderText="Surname" SortExpression="Surname" />
        </Columns>
    </asp:GridView>
    <asp:TextBox ID="TextBox1" runat="server" Width="474px"></asp:TextBox>
    <asp:SqlDataSource ID="SqlDataSource4" runat="server" ConnectionString="<%$ ConnectionStrings:StudArch %>" DeleteCommand="DELETE FROM [Students] WHERE [id] = @id" InsertCommand="INSERT INTO [Students] ([Name], [Patronomic], [Surname]) VALUES (@Name, @Patronomic, @Surname)" SelectCommand="SELECT [id], [Name], [Patronomic], [Surname] FROM [Students]" UpdateCommand="UPDATE [Students] SET [Name] = @Name, [Patronomic] = @Patronomic, [Surname] = @Surname WHERE [id] = @id">
        <DeleteParameters>
            <asp:Parameter Name="id" Type="Int64" />
        </DeleteParameters>
        <InsertParameters>
            <asp:Parameter Name="Name" Type="String" />
            <asp:Parameter Name="Patronomic" Type="String" />
            <asp:Parameter Name="Surname" Type="String" />
        </InsertParameters>
        <UpdateParameters>
            <asp:Parameter Name="Name" Type="String" />
            <asp:Parameter Name="Patronomic" Type="String" />
            <asp:Parameter Name="Surname" Type="String" />
            <asp:Parameter Name="id" Type="Int64" />
        </UpdateParameters>
    </asp:SqlDataSource>
<asp:SqlDataSource ID="SqlDataSource1" runat="server" ConnectionString="<%$ ConnectionStrings:StudArch %>" SelectCommand="SELECT CONCAT([id],' ',[Name],' ',[Patronomic],' ',[Surname]) FROM [dbo].[Students]"></asp:SqlDataSource>
</asp:Content>
