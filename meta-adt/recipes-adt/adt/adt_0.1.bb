SUMMARY = "bitbake-layers recipe"
DESCRIPTION = "Add the files required for the board image to have all the required software and be able to be made read-only."
LICENSE = "CLOSED"
PR = "r0"

do_install() {
   install -d ${D}${base_prefix}/etc/network
   cp -R --no-dereference --preserve=mode,links   ${WORKDIR}/files/etc/network      ${D}${base_prefix}/etc
   
   install -d ${D}${base_prefix}/home/root/.ssh
   cp -R --no-dereference --preserve=mode,links   ${WORKDIR}/files/home/root/.ssh   ${D}${base_prefix}/home/root
}

