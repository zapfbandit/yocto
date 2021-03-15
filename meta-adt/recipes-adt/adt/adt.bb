SUMMARY = "ADT Files Recipe"

DESCRIPTION = "Add the files required for the board image to have all the required software and be able to be made read-only."

LICENSE = "CLOSED"

inherit allarch

FILESEXTRAPATHS_prepend := "${THISDIR}:"

SRC_URI += " \
    file://files/etc/resolv.conf \
    file://files/etc/network/interfaces \
    file://files/home/root/.ssh/devkey \
    file://files/home/root/.ssh/devkey.pub \
"

do_install() {

   install -d ${D}/etc
   install -m 666 ${WORKDIR}/files/etc/resolv.conf           ${D}/etc/
   
   install -d ${D}/etc/network/
   install -m 666 ${WORKDIR}/files/etc/network/interfaces    ${D}/etc/network/
   
   install -d ${D}/home/root/.ssh/
   install -m 666 ${WORKDIR}/files/home/root/.ssh/devkey     ${D}/home/root/.ssh/
   install -m 666 ${WORKDIR}/files/home/root/.ssh/devkey.pub ${D}/home/root/.ssh/   
}

FILES_${PN} += " \
   /etc/resolv.conf \
   /etc/network/interfaces \
   /home/root/.ssh/devkey \
   /home/root/.ssh/devkey.pub \
"
