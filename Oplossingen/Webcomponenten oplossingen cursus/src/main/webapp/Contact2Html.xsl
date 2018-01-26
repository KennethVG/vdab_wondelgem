<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
   xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
   xmlns:ct="http://www.noelvaes.eu/contact">
   <xsl:output method="html" />
   <xsl:template match="/">
      <html>
         <body>
            <div align="center">
               <h1>Contact</h1>
               <xsl:apply-templates select="ct:contact" />
            </div>
         </body>
      </html>
   </xsl:template>

   <xsl:template match="ct:contact">
      <table border="1">
         <tr>
            <td>Name:</td>
            <td><xsl:value-of select="ct:name" /></td>
         </tr>
         <tr>
            <td>Address:</td>
            <td><xsl:value-of select="ct:address" /></td>
         </tr>
         <tr>
            <td>City:</td>
            <td><xsl:value-of select="ct:city" /></td>
         </tr>
         <tr>
            <td>Country:</td>
            <td><xsl:value-of select="ct:country" /></td>
         </tr>
         <xsl:apply-templates select="ct:phone"/>
      </table>
   </xsl:template>

   <xsl:template match="ct:phone">
      <tr>
         <td>Phone:</td>
         <td>
            <xsl:value-of select="." />
         </td>
      </tr>
   </xsl:template>

</xsl:stylesheet>
