<?xml version="1.0" encoding="ISO-8859-1"?>
 
<!-- 	(c) GNU General Public License
	Author: Benno Luthiger, Aktion HIP, Switzerland
-->
  
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method="html" encoding="ISO-8859-1"/>

<xsl:template match="/">
	<table>
	  <tr>
	    <td width="100"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
	    <td>
	        <img src="./images/logo_mini_eng.gif" alt="University of Zurich" align="right"/>
		<h2>FASD Survey</h2>
		<p><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></p>
		<h3><xsl:value-of select="Root/Message"/></h3>
		<p><xsl:value-of select="$QuestionLbl"/></p>
		<form name="Form" action="./" method="post">
		<p>
			<input class="button" name="back" type="submit" value="{$LoginLbl}" />
		</p>
		</form>
	    </td>
	    <td width="100"><xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text></td>
	  </tr>
	</table>
</xsl:template>
  
</xsl:stylesheet>
