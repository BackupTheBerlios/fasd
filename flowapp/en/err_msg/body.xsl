<?xml version="1.0" encoding="ISO-8859-1"?>

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<xsl:output method="html" encoding="ISO-8859-1"/>

<xsl:template match="*|/"><xsl:apply-templates/></xsl:template>
<xsl:template match="text()|@*"><xsl:value-of select="."/></xsl:template>

<xsl:template match="Error">
		<table width="100%" border="0" cellspacing="10">
 			<tr>
				<td>
                                        <img src="./images/logo_mini_eng.gif" alt="University of Zurich" align="right"/>
                                        <h2>FASD Survey</h2>
				</td>
			</tr>
			<tr>
				<td align="left" bgcolor="#429BD6">
					<font color="white" size="2" face="Arial">
						<b>An error occurred:</b>
					</font>
				</td>
			</tr>
			<tr>
				<td>
					<br/>
					<br/>
					<br/>
						<b>
							<font face="Arial" color="#cc0000" size="3">
								<xsl:value-of select="Message"/>
							</font>
						</b>
					<br/>
					<br/>
					<br/>
				</td>
			</tr>
			<tr>
				<td>
					<input class="button" name="button" type="button" value="Back" onClick="javascript:history.back();history.back()"/>
				</td>
			</tr>
			<tr style="font-size:2.5pt;">
				<td bgcolor="#429BD6"><img src="./images/Pixel_1x1.gif" hspace="10" vspace="2,5" width="1" height="1"/></td>
			</tr>
		</table>
	</xsl:template>

</xsl:stylesheet>
