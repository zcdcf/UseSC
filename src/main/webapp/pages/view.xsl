<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html" doctype-system="about:legacy-compat"
                encoding="UTF-8" indent="yes" />

    <xsl:template match="/">
        <html>
            <head>
                <title><xsl:value-of select="view/header/title"/></title>
            </head>
            <body>
                <xsl:for-each select="view/body/form">
                    <form name="{name}" action="{action}" method="{method}">
                        <xsl:for-each select="textView">
                            <p><xsl:value-of select="lable"/></p>
                            <input type="text" name="{name}" value="{value}"/><br/>
                        </xsl:for-each>
                        <br/><input type="button" name="{buttonView/name}" value="{buttonView/lable}"/><br/>
                    </form>
                </xsl:for-each>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>