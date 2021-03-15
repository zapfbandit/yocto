FILESEXTRAPATHS_prepend := "${THISDIR}:"

SRC_URI += " \
    file://files/etc/network/interfaces \
"

do_install_append() {

   install -d ${D}/etc/network/
   install -m 666 ${WORKDIR}/files/etc/network/interfaces    ${D}/etc/network/
}

