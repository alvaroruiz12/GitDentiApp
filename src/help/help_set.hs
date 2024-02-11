<helpset version="1.0">
    <title>Manual de la aplicació</title>
    <maps>
        <!--home id es para ver el primero que me abre-->
        <!--map ref es la localizacion-->
        <homeID>main</homeID>
        <mapref location="mapa.jhm"></mapref>
    </maps>

    <view>
        <name> Tabla de contenidos</name>
        <label> Tabla de contenidos</label>
        <type> javax.help.TOCview</type>
        <data>toc.xml </data>
    
    </view>
    
    <view>
        <name>Indice</name>
        <label>Indice</label>
        <type> javax.help.IndexView</type>
        <data>indice.xml </data>
    
    </view>
    
    <view>
        <name>Buscar </name>
        <label> Buscar</label>
        <type>javax.help.SearchView </type>
        <data engine="com.sum.java.help.search.DefaultSearchEngine">
            JavaHelpSearch
        </data>
    </view>
</helpset>